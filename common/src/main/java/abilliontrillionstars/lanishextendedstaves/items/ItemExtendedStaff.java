package abilliontrillionstars.lanishextendedstaves.items;

import abilliontrillionstars.lanishextendedstaves.registry.LanisHextendedStavesItems;
import at.petrak.hexcasting.api.misc.DiscoveryHandlers;
import at.petrak.hexcasting.common.items.ItemStaff;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EquipmentSlot;

import static abilliontrillionstars.lanishextendedstaves.LanisHextendedStaves.id;
import static abilliontrillionstars.lanishextendedstaves.registry.LanisHextendedStavesItems.EXTENDED_STAFF_IDS;

public class ItemExtendedStaff extends ItemStaff
{
    public ItemExtendedStaff(Properties properties)
    {
        super(properties);

        for(String staff : EXTENDED_STAFF_IDS)
        {
            DiscoveryHandlers.addGridScaleModifier(player -> player.getItemBySlot(EquipmentSlot.MAINHAND).is(Registry.ITEM.get(id(staff))) ? 0.985f : 1);
            DiscoveryHandlers.addGridScaleModifier(player -> player.getItemBySlot(EquipmentSlot.OFFHAND).is(Registry.ITEM.get(id(staff))) ? 0.985f : 1);
        }
    }
}
