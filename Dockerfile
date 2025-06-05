# Usa una imagen de Maven con JDK 21 para compilar
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Copia el contenido del proyecto al contenedor
COPY . /app
WORKDIR /app

# Compila el proyecto con Maven
RUN mvn clean package -DskipTests

# Usa una imagen más ligera para la parte final
FROM eclipse-temurin:21-jdk
COPY --from=build /app/target/*.jar /app/app.jar

# Comando por defecto (puede ajustarse según se necesite)
CMD ["java", "-jar", "/app/app.jar"]
