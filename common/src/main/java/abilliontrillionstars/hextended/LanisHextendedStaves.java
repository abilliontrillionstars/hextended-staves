package abilliontrillionstars.hextended;

import abilliontrillionstars.hextended.items.DrawingOrbAmbit;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.interop.HexInterop;
import dev.architectury.platform.Platform;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vazkii.patchouli.api.PatchouliAPI;

/**
 * This is effectively the loading entrypoint for most of your code, at least
 * if you are using Architectury as intended.
 */
public class LanisHextendedStaves {
    public static final String MOD_ID = "hextended";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static void init()
    {
        //LanisHextendedStavesItems.init();
        LOGGER.info(LanisHextendedStavesAbstractions.getConfigDirectory().toAbsolutePath().normalize().toString());
        CastingEnvironment.addCreateEventListener(
                (CastingEnvironment castenv) -> { castenv.addExtension(new DrawingOrbAmbit(castenv)); }
        );

        String[] interopMods = {};
        for(String mod : interopMods)
            if(Platform.isModLoaded(mod))
                PatchouliAPI.get().setConfigFlag(HexInterop.PATCHOULI_ANY_INTEROP_FLAG, true);
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}
