package abilliontrillionstars.hextended.mixin;

import at.petrak.hexcasting.common.msgs.MsgShiftScrollC2S;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(MsgShiftScrollC2S.class)
public interface AccessorMsgShiftScrollC2S
{
    @Invoker("spellbook")
    void hextended$spellbook(ServerPlayer sender, InteractionHand hand, ItemStack stack, double delta);
}
