FROM adoptopenjdk/openjdk11:jre11u-nightly

COPY target/dcloud-gateway.jar dcloud-gateway.jar
COPY agent /usr/local/agent

ENV SW_AGENT_NAME "dcloud-gateway"

ENTRYPOINT ["java","-javaagent:/usr/local/agent/skywalking-agent.jar","-jar","/dcloud-gateway.jar"]