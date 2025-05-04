FROM eclipse-temurin:17-jdk-jammy
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
#docker build -t ecommerce-api:v1.0 .
#docker run --name ecommerce-api -d -p 8091:8091 ecommerce-api:v1.0
#docker run --name ecommerce-api -d -p 8091:8091 -v /c/samplevolume:/test ecommerce-api:v1.0
