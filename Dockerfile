FROM openjdk
COPY ./build/libs/friendlyBot-1.0-SNAPSHOT.jar /usr/bin/bot/bot.jar
WORKDIR /usr/bin/bot/
COPY ./token.txt /usr/bin/bot/token.txt
WORKDIR /usr/bin/bot
CMD ["java", "-jar", "bot.jar"]