package abilliontrillionstars.lanishextendedstaves.forge;

import dev.architectury.platform.forge.EventBuses;
import abilliontrillionstars.lanishextendedstaves.LanisHextendedStaves;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * This is your loading entrypoint on forge, in case you need to initialize
 * something platform-specific.
 */
@Mod(LanisHextendedStaves.MOD_ID)
public class LanisHextendedStavesForge {
    public LanisHextendedStavesForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(LanisHextendedStaves.MOD_ID, bus);
        bus.addListener(LanisHextendedStavesClientForge::init);
        LanisHextendedStaves.init();
    }
}
