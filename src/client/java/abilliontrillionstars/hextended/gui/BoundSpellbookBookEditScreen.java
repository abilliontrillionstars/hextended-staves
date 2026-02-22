package abilliontrillionstars.hextended.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.inventory.BookEditScreen;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

@Environment(EnvType.CLIENT)
public class BoundSpellbookBookEditScreen extends BookEditScreen
{
    public BoundSpellbookBookEditScreen(Player player, ItemStack itemStack, InteractionHand interactionHand)
    {
        super(player, itemStack, interactionHand);
    }
}
