package moe.neonoverflow.woopwoop;

import net.fabricmc.api.ModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WoopWoopMod implements ModInitializer {
    public static SoundEvent PULL_UP_EVENT = new SoundEvent(new Identifier("woopwoop:pullup"));

    @Override
    public void onInitialize() {
        Registry.register(Registry.SOUND_EVENT, new Identifier("woopwoop:pullup"), PULL_UP_EVENT);
    }
}
