package abilliontrillionstars.hextended.items;

import abilliontrillionstars.hextended.LanisHextendedStaves;
import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.api.casting.iota.IotaType;
import at.petrak.hexcasting.api.item.IotaHolderItem;
import at.petrak.hexcasting.api.utils.NBTHelper;
import at.petrak.hexcasting.common.items.ItemStaff;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static at.petrak.hexcasting.api.HexAPI.modLoc;

public class ItemDrawingOrb extends ItemStaff implements IotaHolderItem
{
    public ItemDrawingOrb(Properties pProperties)  { super(pProperties); }

    public static final ResourceLocation OVERLAY_PRED = modLoc("overlay_layer");
    public static final String TAG_DATA = "data";
    public static final String TAG_SEALED = "sealed";

    @Override
    public @Nullable CompoundTag readIotaTag(ItemStack stack)
    {
        return NBTHelper.getCompound(stack, TAG_DATA);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand)
    {
        int slot;
        if(hand==InteractionHand.MAIN_HAND)
            slot = 98;
        else
            slot = 99;
        ItemStack stack = player.getSlot(slot).get();
        seal(stack);
        return super.use(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        IotaHolderItem.appendHoverText(this, pStack, pTooltipComponents, pIsAdvanced);
    }
    public static boolean isSealed(ItemStack stack)
    {
        return NBTHelper.getBoolean(stack, TAG_SEALED);
    }
    public static void seal(ItemStack stack) { NBTHelper.putBoolean(stack, TAG_SEALED, true); }
    @Override
    public boolean writeable(ItemStack stack)  { return !isSealed(stack); }
    @Override
    public boolean canWrite(ItemStack stack, @Nullable Iota iota)  { return iota == null || !isSealed(stack); }
    @Override
    public void writeDatum(ItemStack stack, @Nullable Iota iota)
    {
        if (iota == null)
        {
            stack.removeTagKey(TAG_DATA);
            stack.removeTagKey(TAG_SEALED);
        }
        else if (!isSealed(stack))
            NBTHelper.put(stack, TAG_DATA, IotaType.serialize(iota));
    }
}
