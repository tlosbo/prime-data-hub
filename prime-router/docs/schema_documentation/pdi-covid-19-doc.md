
### Schema:         primedatainput/pdi-covid-19
#### Description:   PRIME POC COVID-19 flat file

---

**Name**: Patient_last_name

**Type**: PERSON_NAME

**HL7 Field**: PID-5-1

**Documentation**:

The patient's last name

---

**Name**: Patient_first_name

**Type**: PERSON_NAME

**HL7 Field**: PID-5-2

**Documentation**:

The patient's first name

---

**Name**: Patient_middle_name

**Type**: PERSON_NAME

**HL7 Field**: PID-5-3

---

**Name**: Patient_suffix

**Type**: PERSON_NAME

**HL7 Field**: PID-5-4

---

**Name**: Patient_ID

**Type**: TEXT

**HL7 Field**: MSH-10

**Documentation**:

unique id to track the usage of the message

---

**Name**: Patient_lookup_ID

**Type**: TEXT

**HL7 Field**: PID-3-1

---

**Name**: Ordered_test_code

**Type**: TABLE

**HL7 Field**: OBX-3-1

**Documentation**:

The LOINC code of the test performed. This is a standardized coded value describing the test

---

**Name**: Specimen_source_site_code

**Type**: CODE

**Format**: $code

**HL7 Field**: SPM-8

**Value Sets**

Code | Display
---- | -------
119297000|Blood specimen (specimen)
71836000|Nasopharyngeal structure (body structure)
45206002|Nasal structure (body structure)

---

**Name**: Specimen_type_code

**Type**: CODE

**HL7 Field**: SPM-4

**Value Sets**

Code | Display
---- | -------
258500001|Nasopharyngeal swab
871810001|Mid-turbinate nasal swab
697989009|Anterior nares swab
258411007|Nasopharyngeal aspirate
429931000124105|Nasal aspirate
258529004|Throat swab
119334006|Sputum specimen
119342007|Saliva specimen
258607008|Bronchoalveolar lavage fluid sample
119364003|Serum specimen
119361006|Plasma specimen
440500007|Dried blood spot specimen
258580003|Whole blood sample
122555007|Venous blood specimen

**Documentation**:

The specimen source, such as Blood or Serum

---

**Name**: Device_ID

**Type**: TABLE


**Reference URL**:
[https://confluence.hl7.org/display/OO/Proposed+HHS+ELR+Submission+Guidance+using+HL7+v2+Messages#ProposedHHSELRSubmissionGuidanceusingHL7v2Messages-DeviceIdentification](https://confluence.hl7.org/display/OO/Proposed+HHS+ELR+Submission+Guidance+using+HL7+v2+Messages#ProposedHHSELRSubmissionGuidanceusingHL7v2Messages-DeviceIdentification) 

---

**Name**: Instrument_ID

**Type**: ID

---

**Name**: Testing_lab_specimen_ID

**Type**: ID

**HL7 Field**: SPM-2-1

---

**Name**: Test_result_code

**Type**: CODE

**HL7 Field**: OBX-5

**Value Sets**

Code | Display
---- | -------
260373001|Detected
260415000|Not detected
895231008|Not detected in pooled specimen
462371000124108|Detected in pooled specimen
419984006|Inconclusive

**Documentation**:

The result of the test performed. For IgG, IgM and CT results that give a numeric value put that here.

---

**Name**: Illness_onset_date

**Type**: DATE

**HL7 Field**: AOE

---

**Name**: Specimen_collection_date_time

**Type**: DATETIME

**HL7 Field**: SPM-17-1

**Documentation**:

The date which the specimen was collected. The default format is yyyyMMddHHmmsszz


---

**Name**: Order_test_date

**Type**: DATE

**HL7 Field**: ORC-15

---

**Name**: Test_date

**Type**: DATETIME

**Format**: yyyyMMdd

**HL7 Field**: OBX-19

---

**Name**: Date_result_released

**Type**: DATETIME

**Format**: yyyyMMdd

**HL7 Field**: OBR-22

---

**Name**: Patient_race

**Type**: CODE

**HL7 Field**: PID-10

**Value Sets**

Code | Display
---- | -------
1002-5|American Indian or Alaska Native
2028-9|Asian
2054-5|Black or African American
2076-8|Native Hawaiian or Other Pacific Islander
2106-3|White
2131-1|Other
UNK|Unknown
ASKU|Asked, but unknown

**Documentation**:

The patient's race. There is a common valueset defined for race values, but some states may choose to define different code/value combinations.


---

**Name**: Patient_DOB

**Type**: DATE

**HL7 Field**: PID-7

**Documentation**:

The patient's date of birth. Default format is yyyyMMdd.

Other states may choose to define their own formats.


---

**Name**: Patient_gender

**Type**: CODE

**HL7 Field**: PID-8-1

**Value Sets**

Code | Display
---- | -------
M|Male
F|Female
O|Other
A|Ambiguous
U|Unknown
N|Not applicable

**Documentation**:

The patient's gender. There is a valueset defined based on the values in PID-8-1, but downstream consumers are free to define their own accepted values. Please refer to the consumer-specific schema if you have questions.


---

**Name**: Patient_ethnicity

**Type**: CODE

**HL7 Field**: PID-22

**Value Sets**

Code | Display
---- | -------
H|Hispanic or Latino
N|Non Hispanic or Latino
U|Unknown

**Documentation**:

The patient's ethnicity. There is a valueset defined based on the values in PID-22, but downstream consumers are free to define their own values. Please refer to the consumer-specific schema if you have questions.


---

**Name**: Patient_street

**Type**: STREET

**HL7 Field**: PID-11-1

**Documentation**:

The patient's street address

---

**Name**: Patient_street_2

**Type**: STREET

**HL7 Field**: PID-11-2

**Documentation**:

The patient's second address line

---

**Name**: Patient_city

**Type**: CITY

**HL7 Field**: PID-11-3

**Documentation**:

The patient's city

---

**Name**: Patient_state

**Type**: TABLE

**HL7 Field**: PID-11-4

**Documentation**:

The patient's state

---

**Name**: Patient_zip_code

**Type**: POSTAL_CODE

**HL7 Field**: PID-11-5

**Documentation**:

The patient's zip code

---

**Name**: Patient_phone_number

**Type**: TELEPHONE

**HL7 Field**: PID-13

**Documentation**:

The patient's phone number with area code

---

**Name**: Patient_county

**Type**: TABLE

---

**Name**: Patient_role

**Type**: TEXT

---

**Name**: Employed_in_healthcare

**Type**: CODE

**HL7 Field**: AOE

**Value Sets**

Code | Display
---- | -------
Y|Yes
N|No
UNK|Unknown

**Documentation**:

Is the patient employed in health care?

---

**Name**: Resident_congregate_setting

**Type**: CODE

**HL7 Field**: AOE

**Value Sets**

Code | Display
---- | -------
Y|Yes
N|No
UNK|Unknown

**Documentation**:

Does the patient reside in a congregate care setting?

---

**Name**: First_test

**Type**: CODE

**HL7 Field**: AOE

**Value Sets**

Code | Display
---- | -------
Y|Yes
N|No
UNK|Unknown

**Documentation**:

Is this the patient's first test for this condition?

---

**Name**: Symptomatic_for_disease

**Type**: CODE

**HL7 Field**: AOE

**Value Sets**

Code | Display
---- | -------
Y|Yes
N|No
UNK|Unknown

**Documentation**:

Is the patient symptomatic?

---

**Name**: Testing_lab_name

**Type**: TEXT

**HL7 Field**: OBX-23-1

**Documentation**:

The name of the laboratory which performed the test, can be the same as the sending facility name

---

**Name**: Testing_lab_CLIA

**Type**: ID_CLIA

**HL7 Field**: OBX-23-10

**Documentation**:

CLIA Number from the laboratory that sends the message to DOH

An example of the ID is 03D2159846


---

**Name**: Testing_lab_street

**Type**: STREET

**HL7 Field**: OBX-24-1

---

**Name**: Testing_lab_street_2

**Type**: STREET

**HL7 Field**: OBX-24-2

---

**Name**: Testing_lab_city

**Type**: CITY

**HL7 Field**: OBX-24-3

---

**Name**: Testing_lab_state

**Type**: TABLE

**HL7 Field**: OBX-24-4

---

**Name**: Testing_lab_zip_code

**Type**: POSTAL_CODE

**HL7 Field**: OBX-24-5

---

**Name**: Testing_lab_phone_number

**Type**: TELEPHONE

---

**Name**: Testing_lab_county

**Type**: TABLE

---

**Name**: Organization_name

**Type**: TEXT

**Documentation**:

For cases where organization owns many facilities (eg, a large hospital system)

---

**Name**: Ordering_facility_name

**Type**: TEXT

**HL7 Field**: ORC-21-1

**Documentation**:

The name of the facility which the test was ordered from

---

**Name**: Ordering_facility_street

**Type**: STREET

**HL7 Field**: ORC-22-1

**Documentation**:

The address of the facility which the test was ordered from

---

**Name**: Ordering_facility_street_2

**Type**: STREET

**HL7 Field**: ORC-22-2

**Documentation**:

The secondary address of the facility which the test was ordered from

---

**Name**: Ordering_facility_city

**Type**: CITY

**HL7 Field**: ORC-22-3

**Documentation**:

The city of the facility which the test was ordered from

---

**Name**: Ordering_facility_state

**Type**: TABLE

**HL7 Field**: ORC-22-4

**Documentation**:

The state of the facility which the test was ordered from

---

**Name**: Ordering_facility_zip_code

**Type**: POSTAL_CODE

**HL7 Field**: ORC-22-5

**Documentation**:

The zip code of the facility which the test was ordered from

---

**Name**: Ordering_facility_phone_number

**Type**: TELEPHONE

**HL7 Field**: ORC-23

**Documentation**:

The phone number of the facility which the test was ordered from

---

**Name**: Ordering_facility_county

**Type**: TABLE

---

**Name**: Ordering_provider_ID

**Type**: ID_NPI

**HL7 Field**: ORC-12-1

**Documentation**:

The ordering provider’s National Provider Identifier

---

**Name**: Ordering_provider_last_name

**Type**: PERSON_NAME

**Documentation**:

The last name of provider who ordered the test

---

**Name**: Ordering_provider_first_name

**Type**: PERSON_NAME

**HL7 Field**: ORC-12-3

**Documentation**:

The first name of the provider who ordered the test

---

**Name**: Ordering_provider_street

**Type**: STREET

**HL7 Field**: ORC-24-1

**Documentation**:

The street address of the provider

---

**Name**: Ordering_provider_street_2

**Type**: STREET

**HL7 Field**: ORC-24-2

**Documentation**:

The street second address of the provider

---

**Name**: Ordering_provider_city

**Type**: CITY

**HL7 Field**: ORC-24-3

**Documentation**:

The city of the provider

---

**Name**: Ordering_provider_state

**Type**: TABLE

**HL7 Field**: ORC-24-4

**Documentation**:

The state of the provider

---

**Name**: Ordering_provider_zip_code

**Type**: POSTAL_CODE

**HL7 Field**: ORC-24-5

**Documentation**:

The zip code of the provider

---

**Name**: Ordering_provider_phone_number

**Type**: TELEPHONE

**HL7 Field**: ORC-14

**Documentation**:

The phone number of the provider

---

**Name**: Ordering_provider_county

**Type**: TABLE

---

**Name**: reporting_facility_name

**Type**: TEXT

**HL7 Field**: MSH-4-1

---

**Name**: reporting_facility_clia

**Type**: ID_CLIA

**HL7 Field**: MSH-4-2

---