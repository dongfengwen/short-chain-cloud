FROM adoptopenjdk/openjdk11:jre11u-nightly

COPY target/dcloud-link.jar dcloud-link.jar
COPY agent /usr/local/agent

ENV SW_AGENT_NAME "dcloud-link"

ENTRYPOINT ["java","-javaagent:/usr/local/agent/skywalking-agent.jar","-jar","/dcloud-link.jar"]