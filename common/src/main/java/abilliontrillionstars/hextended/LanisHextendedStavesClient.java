package abilliontrillionstars.hextended;

import abilliontrillionstars.hextended.items.ItemDrawingOrb;
import abilliontrillionstars.hextended.registry.LanisHextendedStavesItems;
import at.petrak.hexcasting.api.item.IotaHolderItem;
import at.petrak.hexcasting.api.utils.NBTHelper;
import at.petrak.hexcasting.client.render.GaslightingTracker;
import at.petrak.hexcasting.common.items.storage.ItemFocus;
import at.petrak.hexcasting.xplat.IClientXplatAbstractions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Predicate;

/**
 * Common client loading entrypoint.
 */
public class LanisHextendedStavesClient
{
    public static void init()
    {
        registerSealableDataHolderOverrides(LanisHextendedStavesItems.DRAWING_ORB,
                stack -> LanisHextendedStavesItems.DRAWING_ORB.readIotaTag(stack) != null,
                ItemDrawingOrb::isSealed);

        registerGaslight4(LanisHextendedStavesItems.EXTENDED_QUENCHED_STAFF);
    }

    private static void registerGaslight4(Item item)
    {
        IClientXplatAbstractions.INSTANCE.registerItemProperty(item,
                GaslightingTracker.GASLIGHTING_PRED, (stack, level, holder, holderID) ->
                        Math.abs(GaslightingTracker.getGaslightingAmount() % 4));
    }

    private static void registerSealableDataHolderOverrides(IotaHolderItem item, Predicate<ItemStack> hasIota, Predicate<ItemStack> isSealed)
    {
        IClientXplatAbstractions.INSTANCE.registerItemProperty((Item) item, ItemDrawingOrb.OVERLAY_PRED,
                (stack, level, holder, holderID) -> {
                    if (!hasIota.test(stack) && !NBTHelper.hasString(stack, IotaHolderItem.TAG_OVERRIDE_VISUALLY))
                        return 0;
                    if (!isSealed.test(stack))
                        return 1;
                    return 2;
                });
    }
}
