package abilliontrillionstars.hextended.registry;

import at.petrak.hexcasting.common.recipe.SealThingsRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static abilliontrillionstars.hextended.LanisHextendedStaves.id;
import static at.petrak.hexcasting.api.HexAPI.modLoc;

public class LanisHextendedStavesRecipes
{
    public LanisHextendedStavesRecipes() {}

    public static void registerSerializers(BiConsumer<RecipeSerializer<?>, ResourceLocation> r) {
        // cold call here bc I'm too lazy to debug a NPE for one recipe
        r.accept(LanisSealThingsRecipe.DRAWING_ORB_SERIALIZER, id("seal_drawing_orb"));
    }

    /*
    public static final RecipeSerializer<LanisSealThingsRecipe> SEAL_DRAWING_ORB = registerSerializer(
           "seal_drawing_orb", LanisSealThingsRecipe.DRAWING_ORB_SERIALIZER);

    private static final Map<ResourceLocation, RecipeSerializer<?>> SERIALIZERS = new LinkedHashMap<>();

    private static <T extends Recipe<?>> RecipeSerializer<T> registerSerializer(String name, RecipeSerializer<T> rs) {
        assert SERIALIZERS != null;
        var old = SERIALIZERS.put(modLoc(name), rs);
        if (old != null) throw new IllegalArgumentException("Typo? Duplicate id " + name);
        return rs;
    }
    */
}
