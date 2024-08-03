# Use an official OpenJDK runtime as a parent image
FROM openjdk:22-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the compiled application JAR file into the container
COPY target/trip-together-api-0.0.1-SNAPSHOT.jar /app/app.jar

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
