package abilliontrillionstars.lanishextendedstaves;

import abilliontrillionstars.lanishextendedstaves.registry.LanisHextendedStavesIotas;
import abilliontrillionstars.lanishextendedstaves.registry.LanisHextendedStavesItems;
import abilliontrillionstars.lanishextendedstaves.registry.LanisHextendedStavesPatterns;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is effectively the loading entrypoint for most of your code, at least
 * if you are using Architectury as intended.
 */
public class LanisHextendedStaves {
    public static final String MOD_ID = "lanishextendedstaves";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static void init() {
        LOGGER.info("Hextended Staves says hello!");

        LanisHextendedStavesItems.init();
        LanisHextendedStavesIotas.init();
        LanisHextendedStavesPatterns.init();

        LOGGER.info(LanisHextendedStavesAbstractions.getConfigDirectory().toAbsolutePath().normalize().toString());
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}