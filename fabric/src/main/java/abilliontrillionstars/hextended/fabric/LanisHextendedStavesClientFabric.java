package abilliontrillionstars.hextended.fabric;

import net.fabricmc.api.ClientModInitializer;
import abilliontrillionstars.hextended.LanisHextendedStavesClient;

/**
 * Fabric client loading entrypoint.
 */
public class LanisHextendedStavesClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LanisHextendedStavesClient.init();
    }
}
