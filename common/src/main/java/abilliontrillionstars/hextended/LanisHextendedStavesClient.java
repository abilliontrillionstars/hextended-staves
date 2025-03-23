package abilliontrillionstars.hextended;

import abilliontrillionstars.hextended.registry.LanisHextendedStavesItems;
import at.petrak.hexcasting.client.render.GaslightingTracker;
import at.petrak.hexcasting.xplat.IClientXplatAbstractions;
import net.minecraft.world.item.Item;

/**
 * Common client loading entrypoint.
 */
public class LanisHextendedStavesClient {
    public static void init() {

        registerGaslight4(LanisHextendedStavesItems.EXTENDED_QUENCHED_STAFF);
    }

    private static void registerGaslight4(Item item) {
        IClientXplatAbstractions.INSTANCE.registerItemProperty(item,
                GaslightingTracker.GASLIGHTING_PRED, (stack, level, holder, holderID) ->
                        Math.abs(GaslightingTracker.getGaslightingAmount() % 4));
    }

}
