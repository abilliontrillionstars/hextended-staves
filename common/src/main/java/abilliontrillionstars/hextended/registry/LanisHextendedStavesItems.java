package abilliontrillionstars.hextended.registry;

import abilliontrillionstars.hextended.items.ItemBatteryStaff;
import abilliontrillionstars.hextended.items.ItemDrawingOrb;
import abilliontrillionstars.hextended.items.ItemExtendedAmethystStaff;
import abilliontrillionstars.hextended.items.ItemExtendedStaff;
import abilliontrillionstars.hextended.items.bookbinding.ItemBoundSpellbook;
import abilliontrillionstars.hextended.items.bookbinding.ItemSpellbookCover;
import abilliontrillionstars.hextended.items.diadem.ItemChargedDiadem;
import at.petrak.hexcasting.common.items.ItemStaff;
import com.google.common.base.Suppliers;
import dev.architectury.platform.Platform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static abilliontrillionstars.hextended.LanisHextendedStaves.id;
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
        registerConditionalItems();
    }

    public static final ItemStaff MOSS_STAFF = makeStaff("moss", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff FLOWERED_MOSS_STAFF = makeStaff("flowered_moss", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff PRISMARINE_STAFF = makeStaff("prismarine", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff DARK_PRISMARINE_STAFF = makeStaff("dark_prismarine", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff OBSIDIAN_STAFF = makeStaff("obsidian", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff PURPUR_STAFF = makeStaff("purpur", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_MOSS_STAFF = makeLongStaff("moss", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_FLOWERED_MOSS_STAFF = makeLongStaff("flowered_moss", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_PRISMARINE_STAFF = makeLongStaff("prismarine", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_DARK_PRISMARINE_STAFF = makeLongStaff("dark_prismarine", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_OBSIDIAN_STAFF = makeLongStaff("obsidian", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_PURPUR_STAFF = makeLongStaff("purpur", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));

    public static final ItemStaff LESSER_BATTERY_STAFF = makeStaff("lesser_battery", new ItemBatteryStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff SEALED_LESSER_BATTERY_STAFF = makeStaff("sealed_lesser_battery", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff LESSER_BATTERY_EXTENDED_STAFF = makeLongStaff("lesser_battery", new ItemExtendedAmethystStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff SEALED_LESSER_BATTERY_EXTENDED_STAFF = makeLongStaff("sealed_lesser_battery", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));


    public static final ItemExtendedStaff EXTENDED_OAK_STAFF = makeLongStaff("oak", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_BIRCH_STAFF = makeLongStaff("spruce", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_SPRUCE_STAFF = makeLongStaff("birch", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_JUNGLE_STAFF = makeLongStaff("jungle", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_DARK_OAK_STAFF = makeLongStaff("dark_oak", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_ACACIA_STAFF = makeLongStaff("acacia", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_CRIMSON_STAFF = makeLongStaff("crimson", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_WARPED_STAFF = makeLongStaff("warped", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_MANGROVE_STAFF = makeLongStaff("mangrove", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_BAMBOO_STAFF = makeLongStaff("bamboo", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_CHERRY_STAFF = makeLongStaff("cherry", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_EDIFIED_STAFF = makeLongStaff("edified", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_MINDSPLICE_STAFF = makeLongStaff("mindsplice", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));

    public static final ItemStaff EXTENDED_QUENCHED_STAFF = makeLongStaff("quenched", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));

    public static final ItemDrawingOrb DRAWING_ORB = makeStaff("drawing_orb", new ItemDrawingOrb(new Item.Properties().stacksTo(1)));

    public static final ItemSpellbookCover SPELLBOOK_COVER = make("spellbook_cover", new ItemSpellbookCover(new Item.Properties().stacksTo(Item.MAX_STACK_SIZE)));
    public static final ItemBoundSpellbook BOUND_SPELLBOOK_TEST = make("bound_spellbook", new ItemBoundSpellbook(new Item.Properties().stacksTo(1)));


    public static final ItemChargedDiadem CHARGED_AMETHYST_DIADEM = make("charged_amethyst_diadem", new ItemChargedDiadem(new Item.Properties().stacksTo(1)));





    public static final ItemStaff LIVINGWOOD_STAFF = makeStaff("livingwood", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff MANASTEEL_STAFF = makeStaff("manasteel", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff TERRASTEEL_STAFF = makeStaff("terrasteel", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff DREAMWOOD_STAFF = makeStaff("dreamwood", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemStaff ELEMENTIUM_STAFF = makeStaff("elementium", new ItemStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_LIVINGWOOD_STAFF = makeLongStaff("livingwood", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_MANASTEEL_STAFF = makeLongStaff("manasteel", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_TERRASTEEL_STAFF = makeLongStaff("terrasteel", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_DREAMWOOD_STAFF = makeLongStaff("dreamwood", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));
    public static final ItemExtendedStaff EXTENDED_ELEMENTIUM_STAFF = makeLongStaff("elementium", new ItemExtendedStaff(new Item.Properties().stacksTo(1)));


    private static void registerConditionalItems()
    {
        if(Platform.isModLoaded("hexcasting"))
            System.out.println("GOOOOOOOOOD evening everybody! this is the LOVELY hextended coming to you UH-LIVE from the soon-to-be-former Registration Event! How are y'all doin' tonight?");
        if(Platform.isModLoaded("botania"))
        {

        }
        else
        {

        }
    }

    private static <T extends Item> T make(ResourceLocation id, T item, @Nullable CreativeModeTab tab) {
        var old = ITEMS.put(id, item);
        if (old != null)
            throw new IllegalArgumentException("Typo? Duplicate id " + id);
        if (tab != null)
            ITEM_TABS.computeIfAbsent(tab, t -> new ArrayList<>()).add(new LanisHextendedStavesItems.TabEntry.ItemEntry(item));
        return item;
    }
    private static <T extends Item> T make(String id, T item) { return make(id(id), item, LanisHextendedStavesCreativeTabs.STAVES); }
    private static <T extends Item> T makeStaff(String id, T item) { return make(id("staff/" + id), item, LanisHextendedStavesCreativeTabs.STAVES); }
    private static <T extends Item> T makeLongStaff(String id, T item) { return make(id("staff/long/" + id), item, LanisHextendedStavesCreativeTabs.STAVES); }

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
