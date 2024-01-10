package abilliontrillionstars.lanishextendedstaves.items;

import abilliontrillionstars.lanishextendedstaves.LanisHextendedStaves;
import abilliontrillionstars.lanishextendedstaves.registry.LanisHextendedStavesItems;
import at.petrak.hexcasting.api.misc.DiscoveryHandlers;
import at.petrak.hexcasting.common.items.ItemStaff;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EquipmentSlot;

import static abilliontrillionstars.lanishextendedstaves.LanisHextendedStaves.id;
import static abilliontrillionstars.lanishextendedstaves.registry.LanisHextendedStavesItems.EXTENDED_STAFF_IDS;
import static abilliontrillionstars.lanishextendedstaves.registry.LanisHextendedStavesItems.EXTENDED_STAFF_SET;

public class ItemExtendedStaff extends ItemStaff
{
    static
    {
        DiscoveryHandlers.addGridScaleModifier(player -> player.getItemBySlot(EquipmentSlot.MAINHAND).getItem().getClass() == ItemExtendedStaff.class ? 0.90f : 1);
        DiscoveryHandlers.addGridScaleModifier(player -> player.getItemBySlot(EquipmentSlot.OFFHAND).getItem().getClass() == ItemExtendedStaff.class ? 0.90f : 1);
    }
    public ItemExtendedStaff(Properties properties)  { super(properties); }
}
