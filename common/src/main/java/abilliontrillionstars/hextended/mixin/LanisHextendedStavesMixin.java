package abilliontrillionstars.hextended.mixin;

import at.petrak.hexcasting.interop.HexInterop;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.patchouli.api.PatchouliAPI;

import static at.petrak.hexcasting.interop.HexInterop.PATCHOULI_ANY_INTEROP_FLAG;

@Mixin(HexInterop.class)
public class LanisHextendedStavesMixin {
    @Inject(at = @At(value = "HEAD"), method = "initPatchouli()V", remap = false)
    private static void init(CallbackInfo info) {
        PatchouliAPI.get().setConfigFlag(PATCHOULI_ANY_INTEROP_FLAG, true);
    }
}