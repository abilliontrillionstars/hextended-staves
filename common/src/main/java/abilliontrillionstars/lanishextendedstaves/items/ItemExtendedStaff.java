package abilliontrillionstars.lanishextendedstaves.items;

import at.petrak.hexcasting.common.items.ItemStaff;
import at.petrak.hexcasting.common.lib.HexAttributes;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ItemExtendedStaff extends ItemStaff
{
    public static final AttributeModifier GRID_ZOOM = new AttributeModifier(
            UUID.fromString("a370ec84-ea18-4de6-8730-4271516dcf9c"),
            "Scrying Lens Zoom", 0.15, AttributeModifier.Operation.ADDITION);

    public ItemExtendedStaff(Properties properties)  { super(properties); }


    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        var out = HashMultimap.create(super.getDefaultAttributeModifiers(slot));
        if (slot == EquipmentSlot.MAINHAND || slot == EquipmentSlot.OFFHAND) {
            out.put(HexAttributes.GRID_ZOOM, GRID_ZOOM);
        }
        return out;
    }
}
