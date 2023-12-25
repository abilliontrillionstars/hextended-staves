package abilliontrillionstars.lanishextendedstaves.fabric;

import net.fabricmc.api.ClientModInitializer;
import abilliontrillionstars.lanishextendedstaves.LanisHextendedStavesClient;

/**
 * Fabric client loading entrypoint.
 */
public class LanisHextendedStavesClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LanisHextendedStavesClient.init();
    }
}
