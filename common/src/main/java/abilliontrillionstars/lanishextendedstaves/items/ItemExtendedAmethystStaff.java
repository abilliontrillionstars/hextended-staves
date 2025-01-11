package abilliontrillionstars.lanishextendedstaves.items;

import abilliontrillionstars.lanishextendedstaves.registry.LanisHextendedStavesItems;
import at.petrak.hexcasting.api.misc.DiscoveryHandlers;
import at.petrak.hexcasting.common.lib.HexAttributes;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.UUID;

public class ItemExtendedAmethystStaff extends ItemBatteryStaff
{
    public static final int CAPACITY_IN_DUST = 50;
    private static final DecimalFormat DUST_AMOUNT = new DecimalFormat("###,###.##");
    private static final DecimalFormat PERCENTAGE = new DecimalFormat("####");

    public static final AttributeModifier GRID_ZOOM = new AttributeModifier(
            UUID.fromString("59d739b8-d419-45f7-a4ea-0efee0e3adf5"),
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
