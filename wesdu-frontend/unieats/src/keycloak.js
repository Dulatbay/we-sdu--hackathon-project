import Keycloak from "keycloak-js";

const keycloak = new Keycloak({
    url: "http://172.20.10.2:8484/auth",
    realm: "wesdu_realm",
    clientId: "wesdu_client",
});
export default keycloak;