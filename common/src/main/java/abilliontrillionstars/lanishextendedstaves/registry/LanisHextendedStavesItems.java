package abilliontrillionstars.lanishextendedstaves.registry;

import abilliontrillionstars.lanishextendedstaves.items.ItemBatteryStaff;
import abilliontrillionstars.lanishextendedstaves.items.ItemExtendedAmethystStaff;
import abilliontrillionstars.lanishextendedstaves.items.ItemExtendedStaff;
import at.petrak.hexcasting.common.items.ItemStaff;
import at.petrak.hexcasting.common.lib.HexItems;
import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static abilliontrillionstars.lanishextendedstaves.LanisHextendedStaves.id;
import static at.petrak.hexcasting.api.HexAPI.modLoc;
import static at.petrak.hexcasting.common.lib.hex.HexActions.make;

public class LanisHextendedStavesItems
{


    public static void registerItems(BiConsumer<Item, ResourceLocation> r) {
        for (var e : ITEMS.entrySet()) {
            r.accept(e.getValue(), e.getKey());
        }
    }

    public static void registerItemCreativeTab(CreativeModeTab.Output r, CreativeModeTab tab) {
        for (var item : ITEM_TABS.getOrDefault(tab, List.of())) {
            item.register(r);
        }
    }

    private static final Map<ResourceLocation, Item> ITEMS = new LinkedHashMap<>(); // preserve insertion order
    private static final Map<CreativeModeTab, List<LanisHextendedStavesItems.TabEntry>> ITEM_TABS = new LinkedHashMap<>();


    public static void init()
    {
        registerExtendedStaves();
        //registerConditionalItems();
    }

    public static final ItemStaff MOSS_STAFF = make("moss_staff", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff FLOWERED_MOSS_STAFF = make("flowered_moss_staff", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff PRISMARINE_STAFF = make("prismarine_staff", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff DARK_PRISMARINE_STAFF = make("dark_prismarine_staff", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff OBSIDIAN_STAFF = make("obsidian_staff", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff PURPUR_STAFF = make("purpur_staff", new ItemStaff(new Item.Properties().stacksTo(1)));

    public static final ItemStaff LESSER_BATTERY_STAFF = make("lesser_battery_staff", new ItemBatteryStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff SEALED_LESSER_BATTERY_STAFF = make("sealed_lesser_battery_staff", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff LESSER_BATTERY_EXTENDED_STAFF = make("lesser_battery_extended_staff", new ItemExtendedAmethystStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff SEALED_LESSER_BATTERY_EXTENDED_STAFF = make("sealed_lesser_battery_extended_staff", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));

    //public static RegistrySupplier<Item> EXTENDED_QUARTZ_STAFF;
    //public static RegistrySupplier<Item> EXTENDED_BLAZE_STAFF;
    //public static RegistrySupplier<Item> EXTENDED_WITHER_STAFF;
    //public static RegistrySupplier<Item> EXTENDED_OWLBERT_STAFF;
    //public static RegistrySupplier<Item> EXTENDED_GHOST_STAFF;
    //public static RegistrySupplier<Item> EXTENDED_CELESTIAL_STAFF;
    //public static RegistrySupplier<Item> EXTENDED_ICE_STAFF;
    //public static RegistrySupplier<Item> EXTENDED_LONGINUS_STAFF;
    //public static RegistrySupplier<Item> EXTENDED_CARROT_STAFF;
    //public static RegistrySupplier<Item> EXTENDED_BEE_STAFF;


    //private static void registerConditionalItems()
    //{
    //    if (Platform.isModLoaded("hexcasting"))
    //        System.out.println("this is the LOVELY lanishextendedstaves coming to you UH-LIVE from the soon-to-be-former Registration Event! How are y'all doin' tonight?");
//
    //    if (Platform.isModLoaded("hexgloop"))
    //    {
    //        System.out.println("Oh my stars! If it isn't Hex Gloop! We finally meet!");
    //        EXTENDED_QUARTZ_STAFF = make("extended_quartz_staff", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    //        EXTENDED_BLAZE_STAFF = make("extended_blaze_staff", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    //        EXTENDED_WITHER_STAFF = make("extended_wither_staff", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    //        EXTENDED_OWLBERT_STAFF = make("extended_owlbert_staff", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    //        EXTENDED_GHOST_STAFF = make("extended_ghost_staff", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    //        EXTENDED_CELESTIAL_STAFF = make("extended_celestial_staff", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    //        EXTENDED_LONGINUS_STAFF = make("extended_longinus_staff", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    //        EXTENDED_ICE_STAFF = make("extended_ice_staff", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    //        EXTENDED_CARROT_STAFF = make("extended_carrot_staff", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    //        EXTENDED_BEE_STAFF = make("extended_bee_staff", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    //    }
    //}

    private static void registerExtendedStaves()
    {
        String[] EXTENDED_STAFF_IDS = {"extended_staff_oak", "extended_staff_spruce",
                "extended_staff_birch", "extended_staff_jungle", "extended_staff_dark_oak", "extended_staff_acacia",
                "extended_staff_crimson", "extended_staff_warped", "extended_staff_edified",
                "extended_moss_staff", "extended_flowered_moss_staff", "extended_prismarine_staff", "extended_dark_prismarine_staff",
                "extended_obsidian_staff", "extended_purpur_staff",};
        for(String id : EXTENDED_STAFF_IDS)
            make(id, new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    }

    private static <T extends Item> T make(ResourceLocation id, T item, @Nullable CreativeModeTab tab) {
        var old = ITEMS.put(id, item);
        if (old != null) {
            throw new IllegalArgumentException("Typo? Duplicate id " + id);
        }
        if (tab != null) {
            ITEM_TABS.computeIfAbsent(tab, t -> new ArrayList<>()).add(new LanisHextendedStavesItems.TabEntry.ItemEntry(item));
        }
        return item;
    }

    private static <T extends Item> T make(String id, T item, @Nullable CreativeModeTab tab) {
        return make(id(id), item, tab);
    }

    private static <T extends Item> T make(String id, T item) {
        return make(id(id), item, LanisHextendedStavesCreativeTabs.STAVES);
    }

    private static Supplier<ItemStack> addToTab(Supplier<ItemStack> stack, CreativeModeTab tab) {
        var memoised = Suppliers.memoize(stack::get);
        ITEM_TABS.computeIfAbsent(tab, t -> new ArrayList<>()).add(new LanisHextendedStavesItems.TabEntry.StackEntry(memoised));
        return memoised;
    }

    private static abstract class TabEntry {
        abstract void register(CreativeModeTab.Output r);

        static class ItemEntry extends LanisHextendedStavesItems.TabEntry
        {
            private final Item item;

            ItemEntry(Item item) {
                this.item = item;
            }

            @Override
            void register(CreativeModeTab.Output r) {
                r.accept(item);
            }
        }

        static class StackEntry extends LanisHextendedStavesItems.TabEntry
        {
            private final Supplier<ItemStack> stack;

            StackEntry(Supplier<ItemStack> stack) {
                this.stack = stack;
            }

            @Override
            void register(CreativeModeTab.Output r) {
                r.accept(stack.get());
            }
        }
    }
}
