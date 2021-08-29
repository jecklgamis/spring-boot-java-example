#!/usr/bin/env bash
KEYSTORE_FILE=src/main/resources/keystore.pfx
SERVER_CERT=src/main/resources/server.crt

rm -f ${KEYSTORE_FILE}
rm -f ${SERVER_CERT}

keytool -genkey -alias spring-boot-java-example \
    -keyalg RSA \
    -keysize 2048 \
    -keystore ${KEYSTORE_FILE} \
    -storepass changeit \
    -keypass changeit \
    -storetype PKCS12 \
    -dname "CN=spring-boot-java-example, OU=Org Unit, O=Org, L=Locality, S=State, C=Country" \

echo "Wrote ${KEYSTORE_FILE}"

keytool -exportcert -rfc  -keystore ${KEYSTORE_FILE} -storepass changeit -alias spring-boot-java-example -file ${SERVER_CERT}
