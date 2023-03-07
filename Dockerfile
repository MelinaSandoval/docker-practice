FROM eclipse-temurin:11.0.18_10-jre-alpine

RUN apk add curl jq

# Workspace
WORKDIR /usr/share/luma

# ADD .jar under target from host
ADD target/luma-web-ui.jar 			luma-qa.jar
ADD target/luma-web-ui-tests.jar 	luma-qa-tests.jar
ADD target/libs							libs

# ADD suite files
ADD src/test/resources/testng_suites/discount-module.xml				discount-module.xml
ADD src/test/resources/testng_suites/filtering-module.xml				filtering-module.xml

# ADD health check script
ADD healthcheck.sh                      healthcheck.sh

ENTRYPOINT sh healthcheck.sh