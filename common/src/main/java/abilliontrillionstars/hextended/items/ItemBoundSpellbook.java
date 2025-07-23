package abilliontrillionstars.hextended.items;

import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.api.casting.iota.IotaType;
import at.petrak.hexcasting.api.item.IotaHolderItem;
import at.petrak.hexcasting.api.utils.NBTHelper;
import at.petrak.hexcasting.common.items.storage.ItemSpellbook;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

import static at.petrak.hexcasting.common.items.storage.ItemFocus.NUM_VARIANTS;

public class ItemBoundSpellbook extends ItemSpellbook
{
    public static String TAG_SELECTED_PAGE = "page_idx";
    // this is a CompoundTag of string numerical keys to SpellData
    // it is 1-indexed, so that 0/0 can be the special case of "it is empty"
    public static String TAG_PAGES = "pages";

    // this stores the names of pages, to be restored when you scroll
    // it is 1-indexed, and the 0-case for TAG_PAGES will be treated as 1
    public static String TAG_PAGE_NAMES = "page_names";

    // this stores the sealed status of each page, to be restored when you scroll
    // it is 1-indexed, and the 0-case for TAG_PAGES will be treated as 1
    public static String TAG_SEALED = "sealed_pages";

    // this stores which variant of the spellbook should be rendered
    public static final String TAG_VARIANT = "variant";
    public static int MAX_PAGES;

    public ItemBoundSpellbook(Properties properties)
    {
        super(properties);
        MAX_PAGES = 64;
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip,
                                TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltip, isAdvanced);

        // add things for attributes here
    }

    @Override
    public void inventoryTick(ItemStack stack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(stack, pLevel, pEntity, pSlotId, pIsSelected);
        // stuff may be needed here?
    }

    public static boolean arePagesEmpty(ItemStack stack) {
        CompoundTag tag = NBTHelper.getCompound(stack, TAG_PAGES);
        return tag == null || tag.isEmpty();
    }

    public static int getPage(ItemStack stack, int ifEmpty) {
        if (arePagesEmpty(stack)) {
            return ifEmpty;
        } else if (NBTHelper.hasNumber(stack, TAG_SELECTED_PAGE)) {
            int index = NBTHelper.getInt(stack, TAG_SELECTED_PAGE);
            if (index == 0) {
                index = 1;
            }
            return index;
        } else {
            return 1;
        }
    }

    public static void setSealed(ItemStack stack, boolean sealed) {
        int index = getPage(stack, 1);

        String nameKey = String.valueOf(index);
        CompoundTag names = NBTHelper.getOrCreateCompound(stack, TAG_SEALED);

        if (!sealed) {
            names.remove(nameKey);
        } else {
            names.putBoolean(nameKey, true);
        }

        if (names.isEmpty()) {
            NBTHelper.remove(stack, TAG_SEALED);
        } else {
            NBTHelper.putCompound(stack, TAG_SEALED, names);
        }

    }

    public static boolean isSealed(ItemStack stack) {
        int index = getPage(stack, 1);

        String nameKey = String.valueOf(index);
        CompoundTag names = NBTHelper.getCompound(stack, TAG_SEALED);
        return NBTHelper.getBoolean(names, nameKey);
    }

    public static int highestPage(ItemStack stack) {
        CompoundTag tag = NBTHelper.getCompound(stack, TAG_PAGES);
        if (tag == null) {
            return 0;
        }
        return tag.getAllKeys().stream().flatMap(s -> {
            try {
                return Stream.of(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                return Stream.empty();
            }
        }).max(Integer::compare).orElse(0);
    }

    public static int rotatePageIdx(ItemStack stack, boolean increase) {
        int idx = getPage(stack, 0);
        if (idx != 0) {
            idx += increase ? 1 : -1;
            idx = Math.max(1, idx);
        }
        idx = Mth.clamp(idx, 0, MAX_PAGES);
        NBTHelper.putInt(stack, TAG_SELECTED_PAGE, idx);

        CompoundTag names = NBTHelper.getCompound(stack, TAG_PAGE_NAMES);
        int shiftedIdx = Math.max(1, idx);
        String nameKey = String.valueOf(shiftedIdx);
        String name = NBTHelper.getString(names, nameKey);
        if (name != null) {
            stack.setHoverName(Component.Serializer.fromJson(name));
        } else {
            stack.resetHoverName();
        }

        return idx;
    }
}
