# Create this container from the official jdk container so that java is available
FROM openjdk:jdk-oracle

# create directory as the working dir
WORKDIR /demo

# copy the built dropdemo jar into the container
COPY ./target/dropdemo-1.0-SNAPSHOT.jar /demo/

# copy the configuration file into the container
COPY dropdemo.yml /demo/

# expose the port on which the application listens for http requests
EXPOSE 9080

# command and parameters to run this application
CMD ["java", "-jar","dropdemo-1.0-SNAPSHOT.jar", "server","dropdemo.yml"]

