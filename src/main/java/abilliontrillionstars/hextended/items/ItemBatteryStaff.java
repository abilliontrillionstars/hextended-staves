package abilliontrillionstars.hextended.items;

import at.petrak.hexcasting.api.item.MediaHolderItem;
import at.petrak.hexcasting.api.misc.MediaConstants;
import at.petrak.hexcasting.api.utils.MathUtils;
import at.petrak.hexcasting.api.utils.MediaHelper;
import at.petrak.hexcasting.api.utils.NBTHelper;
import at.petrak.hexcasting.common.items.ItemStaff;
import at.petrak.hexcasting.common.items.magic.ItemMediaHolder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
import java.util.List;

import static at.petrak.hexcasting.common.items.magic.ItemMediaHolder.*;

public class ItemBatteryStaff extends ItemStaff implements MediaHolderItem
{

    public static final long CAPACITY_IN_DUST = 30;
    private static final DecimalFormat DUST_AMOUNT = new DecimalFormat("###,###.##");
    private static final DecimalFormat PERCENTAGE = new DecimalFormat("####");


    public ItemBatteryStaff(Properties properties)  { super(properties); }
    public void onCraftedBy(ItemStack itemStack, Level level, Player player)  { setMedia(itemStack, getMaxMedia(itemStack)); }



    @Override
    public long getMedia(ItemStack stack)  { return NBTHelper.getInt(stack, TAG_MEDIA); }
    @Override
    public long getMaxMedia(ItemStack stack)  { return MediaConstants.DUST_UNIT * this.CAPACITY_IN_DUST; }
    @Override
    public void setMedia(ItemStack stack, long media)  { NBTHelper.putLong(stack, TAG_MEDIA, MathUtils.clamp(media, 0, getMaxMedia(stack))); }
    @Override
    public boolean canProvideMedia(ItemStack stack)  { return true; }
    @Override
    public boolean canRecharge(ItemStack stack)  { return false; }


    public float getMediaFullness(ItemStack stack) {
        long max = getMaxMedia(stack);
        if (max == 0)  { return 0; }
        return (float) getMedia(stack) / (float) max;
    }
    public boolean isBarVisible(ItemStack stack)  { return getMaxMedia(stack) > 0; }
    @Override
    public int getBarWidth(ItemStack pStack) {
        var media = getMedia(pStack);
        var maxMedia = getMaxMedia(pStack);
        return MediaHelper.mediaBarWidth(media, maxMedia);
    }
    public int getBarColor(ItemStack stack)  { return MediaHelper.mediaBarColor(this.getMedia(stack), this.getMaxMedia(stack)); }

    public long withdrawMedia(ItemStack stack, long cost, boolean simulate) {
        var mediaHere = getMedia(stack);
        if (cost < 0)  { cost = mediaHere; }
        if (!simulate)
        {
            var mediaLeft = mediaHere - cost;
            setMedia(stack, mediaLeft);
            if (mediaLeft < 100)
                stack.shrink(1);
        }

        return Math.min(cost, mediaHere);
    }
    public static ItemStack withMedia(ItemStack stack, int media, int maxMedia) {
        Item item = stack.getItem();
        if (item instanceof ItemMediaHolder)
        {
            NBTHelper.putInt(stack, TAG_MEDIA, media);
            NBTHelper.putInt(stack, TAG_MAX_MEDIA, maxMedia);
        }

        return stack;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        var maxMedia = getMaxMedia(pStack);
        if (maxMedia > 0) {
            var media = getMedia(pStack);
            var fullness = getMediaFullness(pStack);

            var color = TextColor.fromRgb(MediaHelper.mediaBarColor(media, maxMedia));

            var mediamount = Component.literal(DUST_AMOUNT.format(media / (float) MediaConstants.DUST_UNIT));
            var percentFull = Component.literal(PERCENTAGE.format(100f * fullness) + "%");
            var maxCapacity = Component.translatable("hexcasting.tooltip.media", DUST_AMOUNT.format(maxMedia / (float) MediaConstants.DUST_UNIT));

            mediamount.withStyle(style -> style.withColor(HEX_COLOR));
            maxCapacity.withStyle(style -> style.withColor(HEX_COLOR));
            percentFull.withStyle(style -> style.withColor(color));

            pTooltipComponents.add(
                    Component.translatable("hexcasting.tooltip.media_amount.advanced",
                            mediamount, maxCapacity, percentFull));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
