# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Build the Spring Boot application with Maven
RUN ./mvnw clean install

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Define environment variables for the application
ENV SPRING_PROFILES_ACTIVE=production

# Run the Spring Boot application when the container launches
CMD ["java", "-jar", "target/your-app.jar"]
