package abilliontrillionstars.hextended.mixin;

import abilliontrillionstars.hextended.registry.LanisHextendedStavesItems;
import at.petrak.hexcasting.client.ShiftScrollListener;
import at.petrak.hexcasting.interop.HexInterop;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vazkii.patchouli.api.PatchouliAPI;

import static at.petrak.hexcasting.interop.HexInterop.PATCHOULI_ANY_INTEROP_FLAG;

@Mixin(ShiftScrollListener.class)
public class LanisHextendedStavesMixin {
    @Inject(method = "IsScrollableItem", at = @At(value = "RETURN"), remap = false, cancellable = true)
    private static void IsScrollableItem(Item item, CallbackInfoReturnable<Boolean> cir)
    {
        cir.setReturnValue(cir.getReturnValue() || item == LanisHextendedStavesItems.BOUND_SPELLBOOK_TEST);
    }
}

