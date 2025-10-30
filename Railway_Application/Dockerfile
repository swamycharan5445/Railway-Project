# Use official OpenJDK 17 image
FROM eclipse-temurin:17-jdk

# Set working directory inside the container
WORKDIR /app

# Copy everything from your project into the container
COPY . .

# Build your Spring Boot app using Maven Wrapper (skipping tests)
RUN ./mvnw clean package -DskipTests

# Expose the port Render will use
EXPOSE 8080

# Run the built JAR file
CMD ["java", "-jar", "target/Railway_Application-0.0.1-SNAPSHOT.jar"]
