FROM iotacafe/maven:3.5.4.oracle8u181.1.webupd8.1.1-1 as local_stage_build
MAINTAINER galrogozinski@iota.org

WORKDIR ~/IdeaProjects/iri
COPY . /iri
WORKDIR /iri
#install the dependency
RUN mvn clean install -DskipTests
WORKDIR ~/git/delete
COPY . /deletemilestone
WORKDIR /deletemilestone
RUN mvn clean package -DskipTests

# execution image
FROM iotacafe/java:oracle8u181.1.webupd8.1-1
COPY --from=local_stage_build /deletemilestone/target/delete*.jar /deletemilestone/target/
COPY /delete/entrypoint.sh /

ENV DOCKER_DELETE_JAR_PATH "/deletemilestone/target/delete*.jar"
WORKDIR /
ENTRYPOINT [ "/entrypoint.sh" ]
CMD []
