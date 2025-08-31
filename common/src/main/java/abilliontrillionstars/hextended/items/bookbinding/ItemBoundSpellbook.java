package abilliontrillionstars.hextended.items.bookbinding;
import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.api.casting.iota.IotaType;
import at.petrak.hexcasting.api.utils.NBTHelper;
import at.petrak.hexcasting.common.items.storage.ItemSpellbook;
import at.petrak.hexcasting.common.lib.HexItems;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import vazkii.patchouli.api.PatchouliAPI;

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

    public static final String TAG_MAX_PAGES = "max_pages";
    public static final int MAX_PAGES = 32;

    public static final String TAG_BOOK_USE_ACTION = "book_use_action";

    public ItemBoundSpellbook(Properties properties) {super(properties);}

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltip, isAdvanced);
        // add some extra info here for extra attributes
//        tooltip.add(Component.translatable("hexcasting.tooltip.spellbook.page.sealed",
//                    Component.literal(String.valueOf(pageIdx)).withStyle(ChatFormatting.WHITE),
//                    Component.literal(String.valueOf(highest)).withStyle(ChatFormatting.WHITE),
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
        // get from nbt
        int max;
        if(NBTHelper.hasInt(stack, TAG_MAX_PAGES))
            max = NBTHelper.getInt(stack, TAG_MAX_PAGES);
        else
            max = MAX_PAGES;

        idx = Mth.clamp(idx, 0, max);
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

    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand)
    {
        ItemStack stack = player.getItemInHand(hand);
        String useAction = NBTHelper.getString(stack, TAG_BOOK_USE_ACTION);

        if(useAction == null)
            return super.use(world, player, hand);

        if(useAction.equals("hexbook"))
            PatchouliAPI.get().openBookGUI(new ResourceLocation("hexcasting", "thehexbook"));
        return super.use(world, player, hand);
    }
}
