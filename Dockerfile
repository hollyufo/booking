FROM openjdk:19
WORKDIR /app
COPY ./target/booking-0.0.1-SNAPSHOT.jar /app
CMD ["java","-jar","/app/booking-0.0.1-SNAPSHOT.jar"]
# port
EXPOSE 8083