package moe.neonoverflow.woopwoop;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;

public class PullUpPlayer {
    private static final MinecraftClient client = MinecraftClient.getInstance();
    private static final PositionedSoundInstance sound = PositionedSoundInstance.master(WoopWoopMod.PULL_UP_EVENT, 1.0f);

    public static boolean isPlaying() { return client.getSoundManager().isPlaying(sound); }

    public static void play() {
        client.getSoundManager().play(sound);
    }

    public static void stop() { client.getSoundManager().stop(sound); }
}
