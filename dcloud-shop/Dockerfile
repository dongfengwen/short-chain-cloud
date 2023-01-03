FROM adoptopenjdk/openjdk11:jre11u-nightly

COPY target/dcloud-shop.jar dcloud-shop.jar
COPY agent /usr/local/agent

ENV SW_AGENT_NAME "dcloud-shop"

ENTRYPOINT ["java","-javaagent:/usr/local/agent/skywalking-agent.jar","-jar","/dcloud-shop.jar"]