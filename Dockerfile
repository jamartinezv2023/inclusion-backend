# Usar imagen base oficial de OpenJDK
FROM eclipse-temurin:21-jdk-alpine as builder

WORKDIR /app

# Copiar el código fuente y construir el .jar con Maven
COPY . .

RUN ./mvnw clean package -DskipTests

# Segunda etapa: imagen liviana
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS=""

ENTRYPOINT exec java $JAVA_OPTS -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -jar app.jar
