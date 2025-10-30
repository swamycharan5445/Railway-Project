# Use official Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper and project files
COPY . .

# Build the Spring Boot jar using Maven wrapper
RUN ./mvnw clean package -DskipTests

# Expose port 8080 (Render will map this automatically)
EXPOSE 8080

# Run the Spring Boot jar
CMD ["java", "-jar", "target/Railway_Application-0.0.1-SNAPSHOT.jar"]
