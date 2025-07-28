package abilliontrillionstars.hextended.mixin;

import abilliontrillionstars.hextended.items.bookbinding.ItemBoundSpellbook;
import abilliontrillionstars.hextended.registry.LanisHextendedStavesItems;
import at.petrak.hexcasting.common.msgs.MsgShiftScrollC2S;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

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
        spellbook(sender, hand, stack, delta);
    }

    @WrapOperation(method = "spellbook",
            at = @At(value = "INVOKE", target = "Lat/petrak/hexcasting/common/items/storage/ItemSpellbook;highestPage(Lnet/minecraft/world/item/ItemStack;)I", remap = false))
    private int boundHighestPage(ItemStack stack, Operation<Integer> original)
    {
        if(stack.getItem() == LanisHextendedStavesItems.BOUND_SPELLBOOK_TEST)
            return ItemBoundSpellbook.highestPage(stack);
        return original.call(stack);
    }

    @WrapOperation(method = "spellbook",
            at = @At(value = "INVOKE", target = "Lat/petrak/hexcasting/common/items/storage/ItemSpellbook;rotatePageIdx(Lnet/minecraft/world/item/ItemStack;Z)I", remap = false))
    private int boundRotateIdx(ItemStack stack, boolean increase, Operation<Integer> original)
    {
        if(stack.getItem() == LanisHextendedStavesItems.BOUND_SPELLBOOK_TEST)
            return ItemBoundSpellbook.rotatePageIdx(stack, increase);
        return original.call(stack, increase);
    }
}
