package abilliontrillionstars.hextended.mixin;

import abilliontrillionstars.hextended.registry.HextendedStavesItems;
import at.petrak.hexcasting.client.ShiftScrollListener;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShiftScrollListener.class)
public class HextendedStavesMixin {
    @Inject(method = "IsScrollableItem", at = @At(value = "RETURN"), remap = false, cancellable = true)
    private static void IsScrollableItem(Item item, CallbackInfoReturnable<Boolean> cir)
    {
        cir.setReturnValue(cir.getReturnValue() || item == HextendedStavesItems.BOUND_SPELLBOOK_TEST);
    }
}

