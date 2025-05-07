package abilliontrillionstars.hextended.items;

import abilliontrillionstars.hextended.LanisHextendedStaves;
import at.petrak.hexcasting.api.addldata.ADIotaHolder;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironmentComponent;
import at.petrak.hexcasting.api.casting.iota.EntityIota;
import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.api.casting.iota.IotaType;
import at.petrak.hexcasting.api.casting.iota.Vec3Iota;
import at.petrak.hexcasting.api.utils.HexUtils;
import at.petrak.hexcasting.api.utils.NBTHelper;
import at.petrak.hexcasting.xplat.IXplatAbstractions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.apache.logging.log4j.core.jmx.Server;
import org.jetbrains.annotations.NotNull;

import static abilliontrillionstars.hextended.items.ItemDrawingOrb.TAG_DATA;

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

        LivingEntity caster = env.getCastingEntity();
        if(caster == null) return current;

        ItemStack orb = null;
        // a drawing orb must be held (in either hand)

        if(caster.getOffhandItem().getItem().getClass() == ItemDrawingOrb.class)
            orb = caster.getOffhandItem();
        if(caster.getMainHandItem().getItem().getClass() == ItemDrawingOrb.class)
            orb = caster.getMainHandItem();
        if (orb == null) return current;
        LanisHextendedStaves.LOGGER.info("orb found!");

        // an iota must be in that drawing orb
        ServerLevel level = env.getWorld();
        LanisHextendedStaves.LOGGER.info("pondering...");
        ADIotaHolder holder = IXplatAbstractions.INSTANCE.findDataHolder(orb);
        if(holder == null) return current;
        Iota iota = holder.readIota(level);
        if(iota == null) return current;
        LanisHextendedStaves.LOGGER.info("the orb answered... iota is: {}", iota);

        // that iota must be something we can grant ambit on
        IotaType<?> type = iota.getType();
        Tag tag = holder.readIotaTag();
        Iota datum = type.deserialize(tag, level);
        LanisHextendedStaves.LOGGER.info("datum provided by iota is: {}", datum);
        if(!(datum instanceof EntityIota) && !(datum instanceof Vec3Iota))
            return current;

        Vec3 target = null;
        // finally, grant ambit
        boolean modified = false;
        if(datum instanceof EntityIota)
        {
            target = ((EntityIota) datum).getEntity().position();
            LanisHextendedStaves.LOGGER.info("orb ponders an entity, at position {}", target);
            LanisHextendedStaves.LOGGER.info("the position the holder seeks being {}", vec);
        }
        else
            target = ((Vec3Iota) datum).getVec3();

        modified = target.subtract(vec).length() < 1;

        if(modified && !current)
            LanisHextendedStaves.LOGGER.info("the orb provides.");

        return current || modified;
    }
}
