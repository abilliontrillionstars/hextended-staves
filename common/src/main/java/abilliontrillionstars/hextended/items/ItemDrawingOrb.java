package abilliontrillionstars.hextended.items;

import abilliontrillionstars.hextended.LanisHextendedStaves;
import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.api.casting.iota.IotaType;
import at.petrak.hexcasting.api.item.IotaHolderItem;
import at.petrak.hexcasting.api.utils.NBTHelper;
import at.petrak.hexcasting.common.items.ItemStaff;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemDrawingOrb extends ItemStaff implements IotaHolderItem
{
    public ItemDrawingOrb(Properties pProperties)  { super(pProperties); }

    public static final String TAG_DATA = "data";
    public static final String TAG_SEALED = "sealed";

    @Override
    public @Nullable CompoundTag readIotaTag(ItemStack stack)
    {
        return NBTHelper.getCompound(stack, TAG_DATA);
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
    public static void seal(ItemStack stack)
    {
        NBTHelper.putBoolean(stack, TAG_SEALED, true);
    }

    @Override
    public boolean writeable(ItemStack stack)  { return true; }
    @Override
    public boolean canWrite(ItemStack stack, @Nullable Iota iota)  { return true; }
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

        //LanisHextendedStaves.LOGGER.info("Wrote Iota: {}", iota);
    }
}
