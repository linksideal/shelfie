# Use an official JDK runtime as a parent image
FROM openjdk:21-jdk

# Set the working directory
WORKDIR /app

# Copy the application JAR to the container
COPY target/shelfie-0.0.1-SNAPSHOT.jar /app/shelfie-0.0.1-SNAPSHOT.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/shelfie-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=production"]