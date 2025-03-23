package abilliontrillionstars.hextended.items;

import at.petrak.hexcasting.common.lib.HexAttributes;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;

import java.text.DecimalFormat;
import java.util.UUID;

public class ItemExtendedAmethystStaff extends ItemBatteryStaff
{
    public static final int CAPACITY_IN_DUST = 50;
    private static final DecimalFormat DUST_AMOUNT = new DecimalFormat("###,###.##");
    private static final DecimalFormat PERCENTAGE = new DecimalFormat("####");

    public static final AttributeModifier GRID_ZOOM = new AttributeModifier(
            UUID.fromString("a370ec84-ea18-4de6-8730-4271516dcf9c"),
            "Scrying Lens Zoom", 0.33, AttributeModifier.Operation.MULTIPLY_BASE);



    public ItemExtendedAmethystStaff(Item.Properties properties)  { super(properties); }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        var out = HashMultimap.create(super.getDefaultAttributeModifiers(slot));
        if (slot == EquipmentSlot.HEAD || slot == EquipmentSlot.MAINHAND || slot == EquipmentSlot.OFFHAND) {
            out.put(HexAttributes.GRID_ZOOM, GRID_ZOOM);
        }
        return out;
    }
}
