package abilliontrillionstars.hextended.mixin;

import abilliontrillionstars.hextended.registry.LanisHextendedStavesItems;
import at.petrak.hexcasting.common.lib.HexItems;
import at.petrak.hexcasting.common.msgs.MsgShiftScrollC2S;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MsgShiftScrollC2S.class)
public abstract class MsgShiftScrollMixin
{
    @Shadow protected abstract void spellbook(ServerPlayer sender, InteractionHand hand, ItemStack stack, double delta);

    @Inject(method = "handleForHand", at = @At(value = "HEAD"), remap = false)
    private void handleForHand(ServerPlayer sender, InteractionHand hand, double delta, CallbackInfo ci)
    {
        if (delta != 0)
        {
            var stack = sender.getItemInHand(hand);
            if(stack.getItem() == LanisHextendedStavesItems.BOUND_SPELLBOOK_TEST)
                hextended$spellbook(sender, hand, stack, delta);
        }
    }


    @Unique
    void hextended$spellbook(ServerPlayer sender, InteractionHand hand, ItemStack stack, double delta)
    {
        this.spellbook(sender, hand, stack, delta);
    }
}
