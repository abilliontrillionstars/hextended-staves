package abilliontrillionstars.hextended.fabric;

import net.fabricmc.loader.api.FabricLoader;
import abilliontrillionstars.hextended.LanisHextendedStavesAbstractions;

import java.nio.file.Path;

public class LanisHextendedStavesAbstractionsImpl {
    /**
     * This is the actual implementation of {@link LanisHextendedStavesAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
