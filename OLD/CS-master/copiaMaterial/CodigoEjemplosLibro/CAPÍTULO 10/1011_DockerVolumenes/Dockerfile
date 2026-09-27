FROM eclipse-temurin:21
ADD target/ejemplo1011-0.0.1-SNAPSHOT.jar /app.jar
RUN mkdir h2dbfiles
ADD h2dbfiles/mydb.mv.db /h2dbfiles
ENTRYPOINT ["java", "-jar", "/app.jar"]


