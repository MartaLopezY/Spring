FROM bellsoft/liberica-openjdk-alpine:17
ADD target/mlyt10e06b-0.0.1-SNAPSHOT.jar /app.jar
RUN mkdir dbfiles
ADD dbfiles/EmpleadoBD.mv.db /dbfiles
ENTRYPOINT ["java", "-jar", "/app.jar"]
