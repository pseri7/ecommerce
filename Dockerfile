FROM openjdk:8-jdk-alpine
ADD target/ecommerce-order.jar  ecommerce-order.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","ecommerce-order.jar"]