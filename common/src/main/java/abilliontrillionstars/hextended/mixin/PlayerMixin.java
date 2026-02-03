package abilliontrillionstars.hextended.mixin;

import abilliontrillionstars.hextended.LanisHextendedStaves;
import abilliontrillionstars.hextended.registry.LanisHextendedStavesItems;
import at.petrak.hexcasting.common.items.HexBaubleItem;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// https://github.com/Robotgiggle/hierophantics/blob/main/common/src/main/java/robotgiggle/hierophantics/mixin/PlayerEntityMixin.java

@Mixin(Player.class)
public class PlayerMixin {
    @Inject(method = "actuallyHurt", at = @At("TAIL"))
    private void onPlayerHurt(DamageSource source, float f, CallbackInfo ci) {
        Player player = (Player) (Object) this;
        if (player.level().isClientSide() || player.isInvulnerableTo(source))
            return;
        String dmgType = source.getMsgId();
        if (dmgType.equals("hexcasting.overcast"))
            LanisHextendedStaves.LOGGER.info("player overcasted!");
            // TODO: move this to per-plat (ugh,) so it can change the diadem to empty
        }
    }
