FROM iotacafe/maven:3.5.4.oracle8u181.1.webupd8.1.1-1 as local_stage_build
MAINTAINER galrogozinski@iota.org

WORKDIR /iri
RUN git clone https://github.com/iotaledger/iri.git
WORKDIR /iri/iri
RUN git checkout v1.5.6
#install the dependency
RUN mvn install -DskipTests
RUN mkdir -p /.m2/repository/iota/iri/1.5.6-RELEASE
RUN cp target/iri*.jar /.m2/repository/iota/iri/1.5.6-RELEASE/

WORKDIR /deletemilestone
COPY . /deletemilestone
RUN mvn clean package -DskipTests

# execution image
FROM iotacafe/java:oracle8u181.1.webupd8.1-1
COPY --from=local_stage_build /deletemilestone/target/delete*.jar /deletemilestone/target/
COPY /delete/entrypoint.sh /

ENV DOCKER_DELETE_JAR_PATH "/deletemilestone/target/delete*.jar"
WORKDIR /
ENTRYPOINT [ "/entrypoint.sh" ]
CMD []