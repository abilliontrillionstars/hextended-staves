package abilliontrillionstars.lanishextendedstaves.items;

import at.petrak.hexcasting.common.items.ItemStaff;
import at.petrak.hexcasting.common.lib.HexAttributes;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;

import java.util.UUID;

public class ItemExtendedStaff extends ItemStaff
{
    public static final AttributeModifier GRID_ZOOM = new AttributeModifier(
            UUID.fromString("59d739b8-d419-45f7-a4ea-0efee0e3adf5"),
            "Scrying Lens Zoom", 0.33, AttributeModifier.Operation.MULTIPLY_BASE);

    public ItemExtendedStaff(Properties properties)  { super(properties); }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        var out = HashMultimap.create(super.getDefaultAttributeModifiers(slot));
        if (slot == EquipmentSlot.HEAD || slot == EquipmentSlot.MAINHAND || slot == EquipmentSlot.OFFHAND) {
            out.put(HexAttributes.GRID_ZOOM, GRID_ZOOM);
        }
        return out;
    }
}
