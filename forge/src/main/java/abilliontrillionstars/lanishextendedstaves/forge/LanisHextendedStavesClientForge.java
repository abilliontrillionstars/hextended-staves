package abilliontrillionstars.lanishextendedstaves.forge;

import abilliontrillionstars.lanishextendedstaves.LanisHextendedStavesClient;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Forge client loading entrypoint.
 */
public class LanisHextendedStavesClientForge {
    public static void init(FMLClientSetupEvent event) {
        LanisHextendedStavesClient.init();
    }
}
