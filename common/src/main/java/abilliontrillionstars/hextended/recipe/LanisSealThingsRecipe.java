package abilliontrillionstars.hextended.recipe;

import abilliontrillionstars.hextended.items.ItemDrawingOrb;

import abilliontrillionstars.hextended.registry.LanisHextendedStavesItems;
import at.petrak.hexcasting.api.mod.HexTags;
import org.jetbrains.annotations.NotNull;

import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraft.world.level.Level;

public class LanisSealThingsRecipe extends CustomRecipe {

    public static final SimpleCraftingRecipeSerializer<LanisSealThingsRecipe> DRAWING_ORB_SERIALIZER =
            new SimpleCraftingRecipeSerializer<>(LanisSealThingsRecipe::drawingOrb);

    public LanisSealThingsRecipe(ResourceLocation id, CraftingBookCategory category) {
        super(id, category);
    }


    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public boolean matches(CraftingContainer container, Level level) {
        boolean foundComb = false;
        boolean foundSealee = false;

        for (int i = 0; i < container.getContainerSize(); i++) {
            var stack = container.getItem(i);
            if (isCorrectSealee(stack)) {
                if (foundSealee) return false;
                foundSealee = true;
            } else if (stack.is(HexTags.Items.SEAL_MATERIALS)) {
                if (foundComb) return false;
                foundComb = true;
            }
        }
        return foundComb && foundSealee;
    }

    @Override
    public ItemStack assemble(CraftingContainer inv, RegistryAccess registryAccess) {
        ItemStack sealee = ItemStack.EMPTY;

        for (int i = 0; i < inv.getContainerSize(); i++) {
            var stack = inv.getItem(i);
            if (isCorrectSealee(stack)) {
                sealee = stack.copy();
                break;
            }
        }
        if (!sealee.isEmpty()) {
            ItemDrawingOrb.seal(sealee);
            sealee.setCount(1);
        }
        return sealee;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return DRAWING_ORB_SERIALIZER;
    }

    public static LanisSealThingsRecipe drawingOrb(ResourceLocation id, CraftingBookCategory category) {
        return new LanisSealThingsRecipe(id, category);
    }

    private boolean isCorrectSealee(ItemStack stack)
    {
        return stack.is(LanisHextendedStavesItems.DRAWING_ORB)
                && LanisHextendedStavesItems.DRAWING_ORB.readIotaTag(stack) != null
                && !ItemDrawingOrb.isSealed(stack);
    }
}

