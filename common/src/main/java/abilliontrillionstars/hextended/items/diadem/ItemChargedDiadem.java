package abilliontrillionstars.hextended.items.diadem;

import at.petrak.hexcasting.common.items.HexBaubleItem;
import at.petrak.hexcasting.common.lib.HexAttributes;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static at.petrak.hexcasting.common.items.ItemLens.SCRY_SIGHT;

public class ItemChargedDiadem extends Item implements HexBaubleItem
{
    public ItemChargedDiadem(Item.Properties properties) { super(properties); }
    // TODO: make this a separate attr that triggers advancement / damage prevention!!
    @Override
    public Multimap<Attribute, AttributeModifier> getHexBaubleAttrs(ItemStack stack) {
        HashMultimap<Attribute, AttributeModifier> out = HashMultimap.create();
        out.put(HexAttributes.SCRY_SIGHT, SCRY_SIGHT);
        return out;
    }
}
