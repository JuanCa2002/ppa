# Imagen base liviana con Java 17
FROM eclipse-temurin:17-jdk-alpine

# Argumento para el archivo JAR
ARG JAR_FILE=target/ppa-0.0.1-SNAPSHOT.jar

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR desde el host al contenedor
COPY ${JAR_FILE} app.jar

# Puerto en el que escucha la aplicación
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java","-jar","app.jar"]