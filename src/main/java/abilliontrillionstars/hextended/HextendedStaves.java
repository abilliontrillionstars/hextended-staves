package abilliontrillionstars.hextended;

import abilliontrillionstars.hextended.items.DrawingOrbAmbit;
import abilliontrillionstars.hextended.registry.HextendedStavesCreativeTabs;
import abilliontrillionstars.hextended.registry.HextendedStavesItems;
import abilliontrillionstars.hextended.registry.HextendedStavesRecipes;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.interop.HexInterop;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vazkii.patchouli.api.PatchouliAPI;

import java.util.function.BiConsumer;


public class HextendedStaves implements ModInitializer {
	public static final String MOD_ID = "hextended";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		CastingEnvironment.addCreateEventListener(
				(CastingEnvironment castenv) -> { castenv.addExtension(new DrawingOrbAmbit(castenv)); }
		);

		String[] interopMods = {};
		for(String mod : interopMods)
			if(FabricLoader.getInstance().isModLoaded(mod))
				PatchouliAPI.get().setConfigFlag(HexInterop.PATCHOULI_ANY_INTEROP_FLAG, true);

		HextendedStavesItems.init();
		ItemGroupEvents.MODIFY_ENTRIES_ALL.register((tab, entries) -> {
			HextendedStavesItems.registerItemCreativeTab(entries, tab);
		});
		HextendedStavesItems.registerItems(bind(BuiltInRegistries.ITEM));
		HextendedStavesCreativeTabs.registerCreativeTabs(bind(BuiltInRegistries.CREATIVE_MODE_TAB));
		HextendedStavesRecipes.registerSerializers(bind(BuiltInRegistries.RECIPE_SERIALIZER));
	}


	public static ResourceLocation resloc(String string) {
		return new ResourceLocation(MOD_ID, string);
	}
	private <T> BiConsumer<T, ResourceLocation> bind(Registry<? super T> registry) {
		return (t, id) -> Registry.register(registry, id, t);
	}
}