package abilliontrillionstars;

import abilliontrillionstars.hextended.items.ItemDrawingOrb;
import abilliontrillionstars.hextended.registry.HextendedStavesItems;
import at.petrak.hexcasting.api.item.IotaHolderItem;
import at.petrak.hexcasting.client.render.GaslightingTracker;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.BiConsumer;
import java.util.function.Predicate;

import static at.petrak.hexcasting.client.RegisterClientStuff.makeIotaStorageColorizer;

public class HextendedStavesClient implements ClientModInitializer
{
	public void onInitializeClient()
	{
		registerSealableDataHolderOverrides(HextendedStavesItems.DRAWING_ORB,
				stack -> HextendedStavesItems.DRAWING_ORB.readIotaTag(stack) != null,
				ItemDrawingOrb::isSealed);

		registerGaslight4(HextendedStavesItems.EXTENDED_QUENCHED_STAFF);
	}

	private static void registerGaslight4(Item item)
	{
		// TODO: translate to fabric
		//FabricLoader.getInstance(). registerItemProperty(item,
		//		GaslightingTracker.GASLIGHTING_PRED, (stack, level, holder, holderID) ->
		//				Math.abs(GaslightingTracker.getGaslightingAmount() % 4));
	}

	private static void registerSealableDataHolderOverrides(IotaHolderItem item, Predicate<ItemStack> hasIota, Predicate<ItemStack> isSealed)
	{
		// TODO: translate to fabric
		//Registry.registerItemProperty((Item) item, ItemDrawingOrb.OVERLAY_PRED,
		//		(stack, level, holder, holderID) -> {
		//			if (!hasIota.test(stack) && !NBTHelper.hasString(stack, IotaHolderItem.TAG_OVERRIDE_VISUALLY))
		//				return 0;
		//			if (!isSealed.test(stack))
		//				return 1;
		//			return 2;
		//		});
	}
	public static void registerColorProviders(BiConsumer<ItemColor, Item> itemColorRegistry)
	{
		itemColorRegistry.accept(makeIotaStorageColorizer(HextendedStavesItems.DRAWING_ORB::getColor), HextendedStavesItems.DRAWING_ORB);
	}
}