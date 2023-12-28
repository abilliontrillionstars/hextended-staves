package abilliontrillionstars.lanishextendedstaves.items;

import abilliontrillionstars.lanishextendedstaves.registry.LanisHextendedStavesItems;
import at.petrak.hexcasting.api.misc.DiscoveryHandlers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.text.DecimalFormat;

public class ItemExtendedAmethystStaff extends ItemBatteryStaff
{
    public static final int CAPACITY_IN_DUST = 50;
    private static final DecimalFormat DUST_AMOUNT = new DecimalFormat("###,###.##");
    private static final DecimalFormat PERCENTAGE = new DecimalFormat("####");

    static
    {
        DiscoveryHandlers.addGridScaleModifier(player -> player.getItemBySlot(EquipmentSlot.MAINHAND).getItem().getClass() == ItemExtendedAmethystStaff.class ? 0.90f : 1);
        DiscoveryHandlers.addGridScaleModifier(player -> player.getItemBySlot(EquipmentSlot.OFFHAND).getItem().getClass() == ItemExtendedAmethystStaff.class ? 0.90f : 1);
    }
    public ItemExtendedAmethystStaff(Item.Properties properties)  { super(properties); }

}
