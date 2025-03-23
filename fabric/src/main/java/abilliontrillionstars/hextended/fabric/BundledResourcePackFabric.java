
package abilliontrillionstars.hextended.fabric;

import abilliontrillionstars.hextended.LanisHextendedStaves;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;


public class BundledResourcePackFabric
{
    // yoinked from https://github.com/TeamMidnightDust/BetterBeds/blob/6be616e91eea01dba91c842bd5a5bd6693991bba/src/main/java/eu/midnightdust/betterbeds/BetterBedsClient.java#L4
    public static void register()
    {
        FabricLoader.getInstance().getModContainer(LanisHextendedStaves.MOD_ID).ifPresent(modContainer ->
        {
            ResourceManagerHelper.registerBuiltinResourcePack(new ResourceLocation(LanisHextendedStaves.MOD_ID, "staff_name_tweaks"), modContainer, "Staff Terminology", ResourcePackActivationType.NORMAL);
        });
    }
}
