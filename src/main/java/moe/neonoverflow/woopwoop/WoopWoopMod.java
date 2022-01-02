package moe.neonoverflow.woopwoop;

import moe.neonoverflow.woopwoop.config.WoopWoopConfigurator;
import moe.neonoverflow.woopwoop.model.WoopWoopConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WoopWoopMod implements ModInitializer {
    public static SoundEvent PULL_UP_EVENT = new SoundEvent(new Identifier("woopwoop:pullup"));
    public static WoopWoopConfigurator CONFIGURATOR = new WoopWoopConfigurator(FabricLoader.getInstance().getConfigDir().resolve("woopwoop.json").toFile());

    @Override
    public void onInitialize() {
        Registry.register(Registry.SOUND_EVENT, new Identifier("woopwoop:pullup"), PULL_UP_EVENT);
        CONFIGURATOR.load();
    }
}
