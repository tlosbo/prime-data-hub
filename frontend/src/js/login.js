const OKTA_clientId = '0oa6fm8j4G1xfrthd4h6';
const redirectUri = window.location.origin;

var config = {
    logo: '//logo.clearbit.com/cdc.gov',
    language: 'en',
    features: {
        registration: false, // Enable self-service registration flow
        rememberMe: false, // Setting to false will remove the checkbox to save username
        router: true, // Leave this set to true for the API demo
    },
    el: "#okta-login-container",
    baseUrl: `https://hhs-prime.okta.com`,
    clientId: `${OKTA_clientId}`,
    redirectUri: redirectUri,
    authParams: {
        issuer: `https://hhs-prime.okta.com/oauth2/default`
    }
};

var signInWidget = new OktaSignIn(config);
signInWidget.showSignInToGetTokens({ scopes: ['openid', 'email', 'profile'] })
    .then(function (tokens) {
        var jwt = tokens.accessToken.value;
        window.sessionStorage.setItem('jwt', jwt);
        window.location.replace(`${window.location.origin}/daily-data/`);
    });
