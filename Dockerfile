FROM iotaledger/iri:v1.5.6 as local_iri

FROM iotacafe/maven:3.5.4.oracle8u181.1.webupd8.1.1-1
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "/root/.m2"

COPY --from=local_iri /iri/target/iri*.jar  /root/

WORKDIR /deletemilestone
COPY . /deletemilestone

RUN mvn install:install-file -Dfile=/root/iri-1.5.6-RELEASE.jar -DgroupId=com.iota -DartifactId=iri -Dversion=1.5.6-RELEASE -Dpackaging=jar -DgeneratePom=true -DlocalRepositoryPath=/local-maven-repo
RUN mvn clean package -DskipTests


ENV DOCKER_DELETE_JAR_PATH "/deletemilestone/target/delete*.jar"
WORKDIR /
ENTRYPOINT [ "/deletemilestone/entrypoint.sh" ]