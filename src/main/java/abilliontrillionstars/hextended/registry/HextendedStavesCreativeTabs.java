package abilliontrillionstars.hextended.registry;

import abilliontrillionstars.hextended.HextendedStaves;
import abilliontrillionstars.hextended.registry.HextendedStavesItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static at.petrak.hexcasting.api.HexAPI.modLoc;

public class HextendedStavesCreativeTabs
{
    public static void registerCreativeTabs(BiConsumer<CreativeModeTab, ResourceLocation> r) {
        for (var e : TABS.entrySet()) {
            r.accept(e.getValue(), e.getKey());
        }
    }

    private static final Map<ResourceLocation, CreativeModeTab> TABS = new LinkedHashMap<>();

    public static final CreativeModeTab STAVES = register(HextendedStaves.MOD_ID, CreativeModeTab
            .builder(CreativeModeTab.Row.TOP, 7)
            .icon(() -> new ItemStack(HextendedStavesItems.MOSS_STAFF)));

    private static CreativeModeTab register(String name, CreativeModeTab.Builder tabBuilder) {
        var tab = tabBuilder.title(Component.translatable("itemGroup." + name)).build();
        var old = TABS.put(modLoc(name), tab);
        if (old != null) {
            throw new IllegalArgumentException("Typo? Duplicate id " + name);
        }
        return tab;
    }
}
