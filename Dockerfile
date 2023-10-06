FROM maven:3.6.3-openjdk-17
WORKDIR /usr/src/app
COPY ./pom.xml .
RUN mvn clean install -DskipTests
COPY . .
RUN mvn package -DskipTests
ENTRYPOINT ["java", "-jar","target/MaCnss-1.0-SNAPSHOT.jar"]
