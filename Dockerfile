#traemos la imagen de jdk
FROM openjdk:17-jdk-alpine
#creamos directorio en el container
WORKDIR /app
#copemos el jar del target
COPY target/microservice-venta-0.0.1-SNAPSHOT.jar venta-service-app.jar
#exponemos puerto informativo
EXPOSE 8080
#comando para correr la app
ENTRYPOINT ["java","-jar","venta-service-app.jar"]
