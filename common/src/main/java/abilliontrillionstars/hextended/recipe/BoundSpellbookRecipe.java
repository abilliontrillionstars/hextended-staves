package abilliontrillionstars.hextended.recipe;

import abilliontrillionstars.hextended.items.ItemDrawingOrb;

import abilliontrillionstars.hextended.items.bookbinding.ItemSpellbookCover;
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

public class BoundSpellbookRecipe extends CustomRecipe {

    public static final SimpleCraftingRecipeSerializer<BoundSpellbookRecipe> BOUND_SPELLBOOK_SERIALIZER =
            new SimpleCraftingRecipeSerializer<>(BoundSpellbookRecipe::new);
    public BoundSpellbookRecipe(ResourceLocation id, CraftingBookCategory category) { super(id, category); }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 9;
    }

    @Override
    public boolean matches(CraftingContainer container, Level level) {
        boolean foundCover = false;
        int foundParts = 0;
        // mutually exclusive and/or non-stackable parts

        for (int i = 0; i < container.getContainerSize(); i++) {
            var stack = container.getItem(i);
            if (stack.is(LanisHextendedStavesItems.SPELLBOOK_COVER)) {
                if (foundCover) return false;
                foundCover = true;
            } else if (stack.is(HexTags.Items.SEAL_MATERIALS)) {
                if (foundParts > 8) return false;
                foundParts++;
            }
        }
        return foundCover && foundParts > 0;
    }

    @Override
    public ItemStack assemble(CraftingContainer inv, RegistryAccess registryAccess) {
        ItemStack result = ItemStack.EMPTY;
        for (int i = 0; i < inv.getContainerSize(); i++) {
            var stack = inv.getItem(i);
            if (stack.is(LanisHextendedStavesItems.SPELLBOOK_COVER))
            {
                result = stack.copy();
                result.setCount(1);
                break;
            }
        }
        return result;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return BOUND_SPELLBOOK_SERIALIZER;
    }
}

