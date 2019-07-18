FROM java:8
HEALTHCHECK --interval=5s --timeout=3s \
  CMD curl http://192.168.99.100:9999/actuator/health | grep 'UP' || exit 1
LABEL maintainer="mgs2bio@gmail.com"
ADD target/course-api-data-0.0.1-SNAPSHOT.jar //
ENTRYPOINT ["java", "-jar", "/course-api-data-0.0.1-SNAPSHOT.jar"]
