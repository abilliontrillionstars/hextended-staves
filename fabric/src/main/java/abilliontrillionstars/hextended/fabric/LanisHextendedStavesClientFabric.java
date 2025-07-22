package abilliontrillionstars.hextended.fabric;

import net.fabricmc.api.ClientModInitializer;
import abilliontrillionstars.hextended.LanisHextendedStavesClient;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

/**
 * Fabric client loading entrypoint.
 */
public class LanisHextendedStavesClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LanisHextendedStavesClient.init();
        // orb things
        LanisHextendedStavesClient.registerColorProviders(ColorProviderRegistry.ITEM::register);
    }
}
