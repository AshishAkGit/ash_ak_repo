FROM openjdk:8
ADD target/doc-users-mysql.jar doc-users-mysql.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","doc-users-mysql.jar"]