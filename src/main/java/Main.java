import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static void main(String[] args) {
        String token = "";
        try {
            token = readFile("token.txt", StandardCharsets.US_ASCII).trim();
        }
        catch (IOException e) {
            return;
        }

        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();
            if ("poggers".equals(message.getContent())) {
                final MessageChannel channel = message.getChannel().block();
                channel.createMessage("https://i.ytimg.com/vi/kdPE1wwpywo/hqdefault.jpg").block();
            }
        });

        gateway.onDisconnect().block();
    }
}
