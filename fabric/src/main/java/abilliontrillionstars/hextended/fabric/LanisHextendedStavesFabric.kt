package abilliontrillionstars.hextended.fabric;


import abilliontrillionstars.hextended.LanisHextendedStaves
import abilliontrillionstars.hextended.registry.LanisHextendedStavesCreativeTabs
import abilliontrillionstars.hextended.registry.LanisHextendedStavesItems
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import java.util.function.BiConsumer

/**
 * This is your loading entrypoint on fabric(-likes), in case you need to initialize
 * something platform-specific.
 * <br/>
 * Since quilt can load fabric mods, you develop for two platforms in one fell swoop.
 * Feel free to check out the <a href="https://github.com/architectury/architectury-templates">Architectury templates</a>
 * if you want to see how to add quilt-specific code.
 */
class LanisHextendedStavesFabric : ModInitializer {

    override fun onInitialize() {
        LanisHextendedStaves.init();
        LanisHextendedStavesItems.init();

        ItemGroupEvents.MODIFY_ENTRIES_ALL.register {tab, entries ->
            LanisHextendedStavesItems.registerItemCreativeTab(entries::accept, tab)
        }
        LanisHextendedStavesItems.registerItems(bind(BuiltInRegistries.ITEM))
        LanisHextendedStavesCreativeTabs.registerCreativeTabs(bind(BuiltInRegistries.CREATIVE_MODE_TAB))
    }
    private fun <T> bind(registry: Registry<in T>): BiConsumer<T, ResourceLocation> =
        BiConsumer<T, ResourceLocation> { t, id -> Registry.register(registry, id, t) }
}