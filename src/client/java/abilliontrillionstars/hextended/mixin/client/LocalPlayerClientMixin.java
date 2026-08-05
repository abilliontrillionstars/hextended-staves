package abilliontrillionstars.hextended.mixin.client;

import abilliontrillionstars.hextended.gui.BoundSpellbookBookEditScreen;
import abilliontrillionstars.hextended.items.bookbinding.ItemBoundSpellbook;
import abilliontrillionstars.hextended.registry.HextendedStavesItems;
import at.petrak.hexcasting.api.utils.NBTHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class LocalPlayerClientMixin
{
	@Inject(at = @At("HEAD"), method = "openItemGui")
	private void openItemGui(ItemStack itemStack, InteractionHand interactionHand, CallbackInfo info) {
		if (itemStack.is(HextendedStavesItems.BOUND_SPELLBOOK) &&
			(NBTHelper.hasString(itemStack, ItemBoundSpellbook.TAG_BOOK_USE_ACTION) &&
			NBTHelper.getString(itemStack, ItemBoundSpellbook.TAG_BOOK_USE_ACTION).equals("book_and_quill")))
		{
			LocalPlayer player = (LocalPlayer) (Object) this;
			Minecraft.getInstance().setScreen(new BoundSpellbookBookEditScreen(player, itemStack, interactionHand));
		}
	}
}