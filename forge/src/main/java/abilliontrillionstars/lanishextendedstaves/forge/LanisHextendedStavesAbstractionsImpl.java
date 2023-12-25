package abilliontrillionstars.lanishextendedstaves.forge;

import abilliontrillionstars.lanishextendedstaves.LanisHextendedStavesAbstractions;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class LanisHextendedStavesAbstractionsImpl {
    /**
     * This is the actual implementation of {@link LanisHextendedStavesAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
