# 1. используем Java 17 FROM eclipse-temurin:17-jdk-alpine
# 2. создаём рабочую папку WORKDIR /app
 # 3. копируем pom.xml и скачиваем зависимости COPY pom.xml . COPY mvnw . COPY .mvn .mvn RUN ./mvnw dependency:go-offline -B
 # 4. копируем весь проект COPY src src
 # 5. собираем jar RUN ./mvnw clean package -DskipTests
 # 6. запускаем jar CMD ["java", "-jar", "target/instagram-0.0.1-SNAPSHOT.jar"] это что