FROM openjdk
COPY ./ /usr/src/bot/
WORKDIR /usr/src/bot/
RUN "./gradlew jar"
RUN copy build/libs/friendlyBot-1.0-SNAPSHOT.jar /usr/bin/bot.jar
COPY ./token.txt /usr/bin/token.txt
WORKDIR /usr/bin
CMD ["java", "-jar", "bot.jar"]