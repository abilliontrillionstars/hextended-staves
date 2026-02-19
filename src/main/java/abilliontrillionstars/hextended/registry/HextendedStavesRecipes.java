package abilliontrillionstars.hextended.registry;

import abilliontrillionstars.hextended.recipe.BoundSpellbookRecipe;
import abilliontrillionstars.hextended.recipe.LanisSealThingsRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static abilliontrillionstars.hextended.HextendedStaves.LOGGER;
import static abilliontrillionstars.hextended.HextendedStaves.id;

public class HextendedStavesRecipes
{
    public HextendedStavesRecipes() {}

    public static void registerSerializers(BiConsumer<RecipeSerializer<?>, ResourceLocation> r) {
        for (var e : SERIALIZERS.entrySet()) {
            r.accept(e.getValue(), e.getKey());
        }
    }
    private static final Map<ResourceLocation, RecipeSerializer<?>> SERIALIZERS = new LinkedHashMap<>();

    public static final RecipeSerializer<LanisSealThingsRecipe> SEAL_DRAWING_ORB = registerSerializer(
           "seal_drawing_orb", LanisSealThingsRecipe.DRAWING_ORB_SERIALIZER);

    public static final RecipeSerializer<BoundSpellbookRecipe> BOUND_SPELLBOOK = registerSerializer(
            "bound_spellbook", BoundSpellbookRecipe.BOUND_SPELLBOOK_SERIALIZER);


    private static <T extends Recipe<?>> RecipeSerializer<T> registerSerializer(String name, RecipeSerializer<T> rs) {
        var old = SERIALIZERS.put(id(name), rs);
        if (old != null) throw new IllegalArgumentException("Typo? Duplicate id " + name);
        return rs;
    }
}
