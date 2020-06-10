# Building with Octopus

This project has been setup to provide a test application to be deployed by Octopus Deploy. The `application.properties` 
file is expected to be used an Octostash template, and the `#{Environment}` marker replaced
with a value supplied by Octopus.

See https://octopus.com/docs/deploying-applications/deploy-java-applications#variable-substitution-in-java-packages
for more details.

# Building

Both Maven and Gradle build scripts have been included with this package.

Compile with Maven:

```
./mvnw clean package
```

Compile with Gradle

```
./gradlew clean build
```