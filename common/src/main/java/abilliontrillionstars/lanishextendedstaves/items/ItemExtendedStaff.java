package abilliontrillionstars.lanishextendedstaves.items;

import at.petrak.hexcasting.api.misc.DiscoveryHandlers;
import at.petrak.hexcasting.common.items.ItemStaff;
import net.minecraft.world.entity.EquipmentSlot;

public class ItemExtendedStaff extends ItemStaff
{
    static
    {
        DiscoveryHandlers.addGridScaleModifier(player -> player.getItemBySlot(EquipmentSlot.MAINHAND).getItem().getClass() == ItemExtendedStaff.class ? 0.90f : 1);
        DiscoveryHandlers.addGridScaleModifier(player -> player.getItemBySlot(EquipmentSlot.OFFHAND).getItem().getClass() == ItemExtendedStaff.class ? 0.90f : 1);
    }
    public ItemExtendedStaff(Properties properties)  { super(properties); }
}
