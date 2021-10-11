FROM lpicanco/java11-alpine
ARG JAR_FILE
ADD target/${JAR_FILE} workshop.jar

RUN apk update && \
    apk upgrade -U && \
    rm -rf /var/cache/*

RUN sh -c 'touch /workshop.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /workshop.jar" ]