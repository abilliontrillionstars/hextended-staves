package abilliontrillionstars.lanishextendedstaves.registry;

import abilliontrillionstars.lanishextendedstaves.items.ItemExtendedStaff;
import at.petrak.hexcasting.common.lib.HexItems;
import com.ibm.icu.text.UForwardCharacterIterator;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import abilliontrillionstars.lanishextendedstaves.LanisHextendedStaves;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Registry;

import static abilliontrillionstars.lanishextendedstaves.LanisHextendedStaves.id;

public class LanisHextendedStavesItemRegistry {
    // Register items through this
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(LanisHextendedStaves.MOD_ID, Registry.ITEM_REGISTRY);

    public static void init() {
        ITEMS.register();
    }

    // A new creative tab. Notice how it is one of the few things that are not deferred
    //public static final CreativeModeTab HEXTENDED_GEAR = CreativeTabRegistry.create(id("hextended_gear"), () -> new ItemStack(LanisHextendedStavesItemRegistry.EXTENDED_STAFF.get()));

    // During the loading phase, refrain from accessing suppliers' items (e.g. EXAMPLE_ITEM.get()), they will not be available
    //public static final RegistrySupplier<Item> EXTENDED_STAFF = ITEMS.register("extended_staff", () -> new Item(new Item.Properties().tab(HEXTENDED_GEAR)));
    public static final String[] EXTENDED_STAFF_IDS = {"extended_staff"};
    static
    {
        for(String id : EXTENDED_STAFF_IDS)
        {
            ITEMS.register(id, () -> new ItemExtendedStaff(HexItems.unstackable()));
        }
    }
}
