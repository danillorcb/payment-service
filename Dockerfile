FROM openjdk:8
ADD target/payment-service.jar payment-service.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","payment-service.jar"]

