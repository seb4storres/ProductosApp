FROM eclipse-temurin:17

ARG JAR_FILE=build/libs/ProductosApp-0.0.1-SNAPSHOT.jar

COPY  ${JAR_FILE} productosapp.jar

ENTRYPOINT ["java", "-jar", "productosapp.jar"]