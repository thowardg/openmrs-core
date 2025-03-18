# Use the official Maven image as the base image
FROM maven:3.8.3-openjdk-17 as build
# Create and set the working directory
RUN mkdir -p /build
WORKDIR /build
# Copy the project source code into the Docker image
COPY . /build/
# Build the application, skipping tests to speed up the process
RUN mvn clean install -DskipTests=true


# Set the working directory to the specific module
WORKDIR /build/webapp

# Set the entry point to run the Maven verify command for the server module
ENTRYPOINT ["mvn", "jetty:run"]

