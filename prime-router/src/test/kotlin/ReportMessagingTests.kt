package gov.cdc.prime.router

import assertk.Assert
import assertk.all
import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.exists
import assertk.assertions.hasMessage
import assertk.assertions.hasSize
import assertk.assertions.isFailure
import assertk.assertions.isNotEmpty
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
import assertk.assertions.matches
import assertk.assertions.messageContains
import assertk.assertions.prop
import assertk.assertions.support.expected
import assertk.assertions.support.show
import gov.cdc.prime.router.serializers.CsvSerializer
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.nio.charset.StandardCharsets
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ReportMessagingTests {
    // need the elements list to be mutable to manipulate some failures
    val cElement = Element("c_int", csvFields = Element.csvFields("c_csv"),
        cardinality = Element.Cardinality.ONE
    )
    val dElement = Element("d_int", csvFields = Element.csvFields("d_csv"),
        cardinality = Element.Cardinality.ZERO_OR_ONE
    )
    val mutableElements = listOf(
        Element("a", csvFields = Element.csvFields("a")),
        Element("b", csvFields = Element.csvFields("b")),
        cElement,
        dElement
    ).toMutableList()

    // generic schema used by several tests
    val one = Schema(
        name = "one",
        topic = "test",
        elements = mutableElements
    )

    @Test
    fun `test required headers`() {
        // error for cardinatlity one, warning for cardinality zero_or_more
        val csv = """
            a,b
            1,2
        """.trimIndent()

        val csvConverter = CsvSerializer(Metadata(schema = one))
        val result = csvConverter.readExternal("one", ByteArrayInputStream(csv.toByteArray()), TestSource)
        assertThat(result.errors).hasSize(1)
        assertThat(result.errors[0].message.detailMsg()).all {
            contains("Missing", true)
            contains(cElement.fieldMapping)
        }
        assertThat(result.warnings).hasSize(1)
        assertThat(result.warnings[0].message.detailMsg()).all {
            contains("Missing", true)
            contains(dElement.fieldMapping)
        }
    }

    @Test
    fun `test required CSV value`() {
        // empty value for cardinality one with no default value
        val csv = """
            a,b,c_csv,d_csv
            1,2,,
        """.trimIndent()

        val csvConverter = CsvSerializer(Metadata(schema = one))
        val result = csvConverter.readExternal("one", ByteArrayInputStream(csv.toByteArray()), TestSource)
        assertThat(result.errors).hasSize(1)
        assertThat(result.errors[0].message.detailMsg()).all {
            contains("Empty", true)
            contains(cElement.fieldMapping)
        }
    }

    @Test
    fun `test table missing column`() {
        val report = Report(one, listOf(listOf("1", "2", "3", "4")), TestSource)
        val size: Int = one.elements.size
        // add an element with a header name that wont be in the private elementIndex
        val element = Element("bogus", csvFields = Element.csvFields("bogus"))
        mutableElements.add(element)
        assertThat(one.elements).hasSize(size + 1)
        // forces the missing column error due to 'bogus' not in the elementIndex
        assertThat {
            CsvSerializer(Metadata(schema = one)).write(report, ByteArrayOutputStream())
        }.isFailure().all {
            messageContains("table")
            messageContains("missing")
            messageContains(element.fieldMapping)
        }
/*        }.isFailure().messageContains(element.fieldMapping).messageContains("missing", true)
        }.isFailure().all {
            messageContains("table", true)
            messageContains("missing", true)
            messageContains(element.fieldMapping)
        }*/
        // remove the element so other tests are not affected
        mutableElements.remove(mutableElements.last())
        assertThat(one.elements).hasSize(size)
    }

    @Test
    fun `test code values validation`() {
        var element = Element("test_int", csvFields = Element.csvFields("test_csv"),
            type = Element.Type.CODE,
            altValues = listOf(ValueSet.Value(code = "U"))
        )

        assertThat {
            element.toFormatted("alt-@#$", Element.altDisplayToken)
        }.isFailure().hasMessage("Schema Error: 'alt-@#$' is not in altValues set for 'test_csv' ('test_int')")
        assertThat {
            element.toFormatted("code-@#$", Element.codeToken)
        }.isFailure().hasMessage("Unable to find a value set for 'test_csv' ('test_int').")
        assertThat {
            element.toFormatted("caret-@^#^$", Element.caretToken)
        }.isFailure().hasMessage("Internal Error: 'caret-@^#^\$' cannot be formatted for 'test_csv' ('test_int')")
        assertThat {
            element.toFormatted("display-@#$", Element.displayToken)
        }.isFailure().hasMessage("Internal Error: 'display-@#\$' cannot be formatted for 'test_csv' ('test_int')")

        element = Element("test_int", csvFields = Element.csvFields("test_csv"),
            type = Element.Type.CODE, altValues = listOf(ValueSet.Value(code = "U")),
            valueSetRef = ValueSet(name = "test_0386", system = ValueSet.SetSystem.LOCAL)
        )
        assertThat {
            element.toFormatted("@#$", Element.codeToken)
        }.isFailure().messageContains("'@#\$' is not in valueSet '${element.valueSet}' for 'test_csv' ('test_int')/'\$code'.")

    }

}

