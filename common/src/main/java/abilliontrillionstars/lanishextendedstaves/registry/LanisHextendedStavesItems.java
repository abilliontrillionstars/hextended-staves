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
import dev.architectury.platform.Platform;

import java.util.HashSet;
import java.util.Set;

public class LanisHextendedStavesItems
{
    // Register items through this
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(LanisHextendedStaves.MOD_ID, Registry.ITEM_REGISTRY);
    public static void init()
    {
        registerExtendedStaves();
        registerConditionalItems();
        ITEMS.register();
    }

    // A new creative tab. Notice how it is one of the few things that are not deferred
    public static final CreativeModeTab HEXTENDED_GEAR = CreativeTabRegistry.create(LanisHextendedStaves.id("hextended_gear"), () -> new ItemStack(LanisHextendedStavesItems.MOSS_STAFF.get()));

    // During the loading phase, refrain from accessing suppliers' items (e.g. EXAMPLE_ITEM.get()), they will not be available
    //public static final RegistrySupplier<Item> EXTENDED_STAFF = ITEMS.register("extended_staff", () -> new Item(new Item.Properties().tab(HEXTENDED_GEAR)));

    public static final RegistrySupplier<Item> MOSS_STAFF = ITEMS.register("moss_staff", () -> new ItemStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
    public static final RegistrySupplier<Item> FLOWERED_MOSS_STAFF = ITEMS.register("flowered_moss_staff", () -> new ItemStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
    public static final RegistrySupplier<Item> PRISMARINE_STAFF = ITEMS.register("prismarine_staff", () -> new ItemStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
    public static final RegistrySupplier<Item> DARK_PRISMARINE_STAFF = ITEMS.register("dark_prismarine_staff", () -> new ItemStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
    public static final RegistrySupplier<Item> OBSIDIAN_STAFF = ITEMS.register("obsidian_staff", () -> new ItemStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
    public static final RegistrySupplier<Item> PURPUR_STAFF = ITEMS.register("purpur_staff", () -> new ItemStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));

    public static final RegistrySupplier<Item> LESSER_BATTERY_STAFF = ITEMS.register("lesser_battery_staff", () -> new ItemBatteryStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
    public static final RegistrySupplier<Item> SEALED_LESSER_BATTERY_STAFF = ITEMS.register("sealed_lesser_battery_staff", () -> new ItemStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
    public static final RegistrySupplier<Item> LESSER_BATTERY_EXTENDED_STAFF = ITEMS.register("lesser_battery_extended_staff", () -> new ItemExtendedAmethystStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
    public static final RegistrySupplier<Item> SEALED_LESSER_BATTERY_EXTENDED_STAFF = ITEMS.register("sealed_lesser_battery_extended_staff", () -> new ItemExtendedStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));

    public static RegistrySupplier<Item> EXTENDED_QUARTZ_STAFF;
    public static RegistrySupplier<Item> EXTENDED_BLAZE_STAFF;
    public static RegistrySupplier<Item> EXTENDED_WITHER_STAFF;
    public static RegistrySupplier<Item> EXTENDED_OWLBERT_STAFF;
    public static RegistrySupplier<Item> EXTENDED_GHOST_STAFF;
    public static RegistrySupplier<Item> EXTENDED_CELESTIAL_STAFF;
    public static RegistrySupplier<Item> EXTENDED_ICE_STAFF;
    public static RegistrySupplier<Item> EXTENDED_LONGINUS_STAFF;
    public static RegistrySupplier<Item> EXTENDED_CARROT_STAFF;
    public static RegistrySupplier<Item> EXTENDED_BEE_STAFF;


    private static void registerConditionalItems()
    {
        if (Platform.isModLoaded("hexcasting"))
            System.out.println("this is the LOVELY lanishextendedstaves coming to you UH-LIVE from the soon-to-be-former Registration Event! How are y'all doin' tonight?");

        if (Platform.isModLoaded("hexgloop"))
        {
            System.out.println("Oh my stars! If it isn't Hex Gloop! We finally meet!");
            EXTENDED_QUARTZ_STAFF = ITEMS.register("extended_quartz_staff", () -> new ItemExtendedStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
            EXTENDED_BLAZE_STAFF = ITEMS.register("extended_blaze_staff", () -> new ItemExtendedStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
            EXTENDED_WITHER_STAFF = ITEMS.register("extended_wither_staff", () -> new ItemExtendedStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
            EXTENDED_OWLBERT_STAFF = ITEMS.register("extended_owlbert_staff", () -> new ItemExtendedStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
            EXTENDED_GHOST_STAFF = ITEMS.register("extended_ghost_staff", () -> new ItemExtendedStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
            EXTENDED_CELESTIAL_STAFF = ITEMS.register("extended_celestial_staff", () -> new ItemExtendedStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
            EXTENDED_LONGINUS_STAFF = ITEMS.register("extended_longinus_staff", () -> new ItemExtendedStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
            EXTENDED_ICE_STAFF = ITEMS.register("extended_ice_staff", () -> new ItemExtendedStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
            EXTENDED_CARROT_STAFF = ITEMS.register("extended_carrot_staff", () -> new ItemExtendedStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
            EXTENDED_BEE_STAFF = ITEMS.register("extended_bee_staff", () -> new ItemExtendedStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
        }
    }

    private static void registerExtendedStaves()
    {
        String[] EXTENDED_STAFF_IDS = {"extended_staff_oak", "extended_staff_spruce",
                "extended_staff_birch", "extended_staff_jungle", "extended_staff_dark_oak", "extended_staff_acacia",
                "extended_staff_crimson", "extended_staff_warped", "extended_staff_edified",
                "extended_moss_staff", "extended_flowered_moss_staff", "extended_prismarine_staff", "extended_dark_prismarine_staff",
                "extended_obsidian_staff", "extended_purpur_staff",};
        for(String id : EXTENDED_STAFF_IDS)
            ITEMS.register(id, () -> new ItemExtendedStaff(new Item.Properties().stacksTo(1).tab(HEXTENDED_GEAR)));
    }
}
