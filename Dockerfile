# Use an official Java runtime as a parent image
FROM eclipse-temurin:17

# Set the working directory
WORKDIR /DockerGilde

# Copy the current directory contents into the container at /app
COPY . .

# Install Firefox
RUN apt-get update && apt-get install -y chrome

# Install Maven (modify this as needed)
RUN apt-get install -y maven

# Build and run your tests
RUN mvn test

# Define the command to run your tests
CMD ["mvn", "test"]