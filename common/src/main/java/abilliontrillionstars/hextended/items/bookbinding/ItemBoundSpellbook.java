package abilliontrillionstars.hextended.items.bookbinding;
import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.api.casting.iota.IotaType;
import at.petrak.hexcasting.api.utils.NBTHelper;
import at.petrak.hexcasting.common.items.storage.ItemSpellbook;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

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

    public static final int MAX_PAGES = 32;

    public ItemBoundSpellbook(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltip, isAdvanced);
        // add some extra info here for extra attributes
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
        if (idx != 0)
        {
            idx += increase ? 1 : -1;
            idx = Math.max(1, idx);
        }
        // TODO: make this get from nbt
        idx = Mth.clamp(idx, 0, MAX_PAGES);
        NBTHelper.putInt(stack, TAG_SELECTED_PAGE, idx);

        CompoundTag names = NBTHelper.getCompound(stack, TAG_PAGE_NAMES);
        int shiftedIdx = Math.max(1, idx);
        String nameKey = String.valueOf(shiftedIdx);
        String name = NBTHelper.getString(names, nameKey);
        if (name != null)
            stack.setHoverName(Component.Serializer.fromJson(name));
        else
            stack.resetHoverName();

        return idx;
    }
}
