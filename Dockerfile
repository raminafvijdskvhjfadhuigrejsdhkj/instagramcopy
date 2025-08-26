# 1. используем Java 17
FROM eclipse-temurin:17-jdk-alpine AS build

# 2. создаём рабочую папку
WORKDIR /app

# 3. копируем Maven wrapper и pom.xml, качаем зависимости
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:go-offline -B

# 4. копируем весь проект
COPY src src

# 5. собираем jar
RUN ./mvnw clean package -DskipTests

# ----
# отдельный stage для запуска (чистый, без Maven)
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# 6. копируем jar из build stage
COPY --from=build /app/target/instagram-0.0.1-SNAPSHOT.jar app.jar

# 7. запускаем jar
CMD ["java", "-jar", "app.jar"]
