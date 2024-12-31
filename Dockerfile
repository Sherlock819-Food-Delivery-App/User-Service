# Use an official openjdk runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY target/User-Service-0.0.1-SNAPSHOT.jar /app/target/User-Service-0.0.1-SNAPSHOT.jar