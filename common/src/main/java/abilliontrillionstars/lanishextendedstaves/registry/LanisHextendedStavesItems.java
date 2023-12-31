package abilliontrillionstars.lanishextendedstaves.registry;

import abilliontrillionstars.lanishextendedstaves.items.ItemBatteryStaff;
import abilliontrillionstars.lanishextendedstaves.items.ItemExtendedAmethystStaff;
import abilliontrillionstars.lanishextendedstaves.items.ItemExtendedStaff;
import at.petrak.hexcasting.common.items.ItemStaff;
import at.petrak.hexcasting.common.lib.HexItems;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import abilliontrillionstars.lanishextendedstaves.LanisHextendedStaves;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.core.Registry;
import net.minecraft.world.item.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class LanisHextendedStavesItems
{
    // Register items through this
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(LanisHextendedStaves.MOD_ID, Registry.ITEM_REGISTRY);
    public static void init() {
        ITEMS.register();
    }

    // A new creative tab. Notice how it is one of the few things that are not deferred
    public static final CreativeModeTab HEXTENDED_GEAR = CreativeTabRegistry.create(LanisHextendedStaves.id("hextended_gear"), () -> new ItemStack(LanisHextendedStavesItems.LESSER_BATTERY_STAFF.get()));

    // During the loading phase, refrain from accessing suppliers' items (e.g. EXAMPLE_ITEM.get()), they will not be available
    //public static final RegistrySupplier<Item> EXTENDED_STAFF = ITEMS.register("extended_staff", () -> new Item(new Item.Properties().tab(HEXTENDED_GEAR)));
    public static final String[] EXTENDED_STAFF_IDS = {"extended_staff_oak", "extended_staff_spruce",
            "extended_staff_birch", "extended_staff_jungle", "extended_staff_dark_oak", "extended_staff_acacia",
            "extended_staff_crimson", "extended_staff_warped", "extended_staff_edified", "sealed_lesser_battery_extended_staff"};
    public static final Set<Item> EXTENDED_STAFF_SET = new HashSet<>();
    public static final RegistrySupplier<Item> LESSER_BATTERY_STAFF = ITEMS.register("lesser_battery_staff", () -> new ItemBatteryStaff(HexItems.unstackable().tab(HEXTENDED_GEAR)));
    public static final RegistrySupplier<Item> SEALED_LESSER_BATTERY_STAFF = ITEMS.register("sealed_lesser_battery_staff", () -> new ItemStaff(HexItems.unstackable().tab(HEXTENDED_GEAR)));
    public static final RegistrySupplier<Item> LESSER_BATTERY_EXTENDED_STAFF = ITEMS.register("lesser_battery_extended_staff", () -> new ItemExtendedAmethystStaff(HexItems.unstackable().tab(HEXTENDED_GEAR)));
    static
    {
        for(String id : EXTENDED_STAFF_IDS)
        {
            ItemExtendedStaff staff = new ItemExtendedStaff(HexItems.unstackable().tab(HEXTENDED_GEAR));
            EXTENDED_STAFF_SET.add(staff);
            ITEMS.register(id, () -> staff);
        }
    }
    public static boolean isExtendedStaff(Item item)  { return EXTENDED_STAFF_SET.contains(item); }

}
