import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.User;
import reactor.core.publisher.Mono;

import java.util.TimerTask;

public class LoopTask extends TimerTask {
    public GatewayDiscordClient gateway;

    public LoopTask(GatewayDiscordClient gateway) {
        this.gateway = gateway;
    }

    @Override
    public void run() {

    }
}
