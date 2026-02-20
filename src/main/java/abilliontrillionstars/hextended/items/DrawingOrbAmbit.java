package abilliontrillionstars.hextended.items;

import abilliontrillionstars.hextended.items.ItemDrawingOrb;

import at.petrak.hexcasting.api.addldata.ADIotaHolder;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironmentComponent;
import at.petrak.hexcasting.api.casting.iota.EntityIota;
import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.xplat.IXplatAbstractions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class DrawingOrbAmbit implements CastingEnvironmentComponent.IsVecInRange
{
    private final CastingEnvironment env;
    public static class DrawingOrbKey implements Key<IsVecInRange> {}

    public DrawingOrbAmbit(CastingEnvironment env) { this.env = env; }

    @Override
    public Key<IsVecInRange> getKey()  { return new DrawingOrbKey(); }
    @Override
    public boolean onIsVecInRange(Vec3 vec, boolean current)
    {
        LivingEntity caster = env.getCastingEntity();
        if(caster == null) return current;

        ItemStack orb = null;
        // a drawing orb must be held (in either hand)
        if(caster.getOffhandItem().getItem().getClass() == ItemDrawingOrb.class)
            orb = caster.getOffhandItem();
        if(caster.getMainHandItem().getItem().getClass() == ItemDrawingOrb.class)
            orb = caster.getMainHandItem();
        if(orb == null) return current;
        //LanisHextendedStaves.LOGGER.info("orb found!");

        // an iota must be in that drawing orb
        ServerLevel level = env.getWorld();
        //LanisHextendedStaves.LOGGER.info("pondering...");
        ADIotaHolder holder = IXplatAbstractions.INSTANCE.findDataHolder(orb);
        if(holder == null) return current;
        Iota datum = holder.readIota(level);
        if(datum == null) return current;
        //LanisHextendedStaves.LOGGER.info("the orb answered... iota is: {}", datum);

        // that iota must be something we can grant ambit on
        if(!(datum instanceof EntityIota)) return current;
        Vec3 target = ((EntityIota) datum).getEntity().position();

        //if(modified && !current) LanisHextendedStaves.LOGGER.info("the orb provides.");

        return current || vec==target;
    }
}
