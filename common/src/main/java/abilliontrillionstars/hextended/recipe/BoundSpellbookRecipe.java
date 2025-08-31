package abilliontrillionstars.hextended.recipe;

import abilliontrillionstars.hextended.items.bookbinding.ItemBoundSpellbook;
import abilliontrillionstars.hextended.items.bookbinding.ItemSpellbookCover;
import abilliontrillionstars.hextended.registry.LanisHextendedStavesItems;
import at.petrak.hexcasting.api.utils.NBTHelper;
import at.petrak.hexcasting.common.lib.HexItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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

import java.util.ArrayList;
import java.util.List;

public class BoundSpellbookRecipe extends CustomRecipe {

    public static final SimpleCraftingRecipeSerializer<BoundSpellbookRecipe> BOUND_SPELLBOOK_SERIALIZER =
            new SimpleCraftingRecipeSerializer<>(BoundSpellbookRecipe::new);
    public BoundSpellbookRecipe(ResourceLocation id, CraftingBookCategory category) { super(id, category); }

    public static final List<Item> BOOK_PARTS = List.of(HexItems.FOCUS, HexItems.SCROLL_LARGE, HexItems.SCROLL_MEDIUM, HexItems.SCROLL_SMOL,
                                                        Items.BOOK);

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
            } else if(BOOK_PARTS.contains(stack.getItem())){
                if (foundParts > 8) return false;
                foundParts++;
            }
            else if(!stack.isEmpty()) // don't eat non-part items
                return false;
        }
        return foundCover && foundParts > 0;
    }

    @Override
    public ItemStack assemble(CraftingContainer inv, RegistryAccess registryAccess) {
        ItemStack result = LanisHextendedStavesItems.BOUND_SPELLBOOK_TEST.getDefaultInstance();
        int pageCount = 0;

        for (int i = 0; i < inv.getContainerSize(); i++)
        {
            var stack = inv.getItem(i);

            if (stack.is(HexItems.FOCUS))
                pageCount += 8;
            else if(stack.is(HexItems.SCROLL_LARGE))
                pageCount += 4;
            else if(stack.is(HexItems.SCROLL_MEDIUM))
                pageCount += 2;
            else if(stack.is(HexItems.SCROLL_SMOL))
                pageCount += 1;
            else if(stack.is(Items.BOOK))
                NBTHelper.putString(result, ItemBoundSpellbook.TAG_BOOK_USE_ACTION, "hexbook");
        }
        NBTHelper.putInt(result, ItemBoundSpellbook.TAG_MAX_PAGES, pageCount);
        return result;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return BOUND_SPELLBOOK_SERIALIZER;
    }
}

