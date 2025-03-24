package abilliontrillionstars.hextended.items;

import abilliontrillionstars.hextended.LanisHextendedStaves;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironmentComponent;
import at.petrak.hexcasting.api.casting.iota.Iota;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class DrawingOrbAmbit implements CastingEnvironmentComponent.IsVecInRange
{
    private final CastingEnvironment env;
    public static class DrawingOrbKey implements Key<IsVecInRange> {}

    public DrawingOrbAmbit(CastingEnvironment env)
    {
        this.env = env;
    }

    @Override
    public Key<IsVecInRange> getKey() {
        return new DrawingOrbKey();
    }

    @Override
    public boolean onIsVecInRange(Vec3 vec, boolean current) {
        ServerPlayer caster = env.getCaster();
        if(caster == null) return current;

        ItemStack orb = null;
        // needs a drawing orb to be held (in either hand)
        if(caster.getOffhandItem().getItem().getClass() != ItemDrawingOrb.class)
            orb = caster.getOffhandItem();

        if(caster.getMainHandItem().getItem().getClass() != ItemDrawingOrb.class)
            orb = caster.getMainHandItem();
        if (orb == null) return current;
        // needs an iota in that drawing orb
        ServerLevel level = env.getWorld();
        Iota iota = readIota(orb, level);

        LanisHextendedStaves.LOGGER.info("pondering thy orb...");
        return current;
    }
}
