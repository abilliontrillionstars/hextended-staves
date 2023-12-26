package abilliontrillionstars.lanishextendedstaves.registry;

import abilliontrillionstars.lanishextendedstaves.items.ItemExtendedStaff;
import at.petrak.hexcasting.common.lib.HexItems;
import dev.architectury.registry.registries.DeferredRegister;
import abilliontrillionstars.lanishextendedstaves.LanisHextendedStaves;
import net.minecraft.world.item.Item;
import net.minecraft.core.Registry;

public class LanisHextendedStavesItems
{
    // Register items through this
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(LanisHextendedStaves.MOD_ID, Registry.ITEM_REGISTRY);

    public static void init() {
        ITEMS.register();
    }

    // A new creative tab. Notice how it is one of the few things that are not deferred
    //public static final CreativeModeTab HEXTENDED_GEAR = CreativeTabRegistry.create(id("hextended_gear"), () -> new ItemStack(LanisHextendedStavesItems.EXTENDED_STAFF.get()));

    // During the loading phase, refrain from accessing suppliers' items (e.g. EXAMPLE_ITEM.get()), they will not be available
    //public static final RegistrySupplier<Item> EXTENDED_STAFF = ITEMS.register("extended_staff", () -> new Item(new Item.Properties().tab(HEXTENDED_GEAR)));
    public static final String[] EXTENDED_STAFF_IDS = {"extended_staff_oak", "extended_staff_spruce",
            "extended_staff_birch", "extended_staff_jungle", "extended_staff_dark_oak", "extended_staff_acacia",
            "extended_staff_crimson", "extended_staff_warped", "extended_staff_edified"};

    static
    {
        for(String id : EXTENDED_STAFF_IDS)
            ITEMS.register(id, () -> new ItemExtendedStaff(HexItems.unstackable()));
    }
}
