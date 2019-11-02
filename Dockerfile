FROM openjdk:oracle
COPY inventario-1.0.0.jar app/inventario-1.0.0.jar
EXPOSE 8080
CMD ["java", "-jar", "app/inventario-1.0.0.jar"]
