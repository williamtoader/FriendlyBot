FROM openjdk
RUN ./gradlew jar
COPY ./build/libs/friendlyBot-1.0-SNAPSHOT.jar /usr/bin/bot.jar
COPY ./token.txt /usr/bin/token.txt
WORKDIR /usr/bin
CMD ["java", "-jar", "bot.jar"]