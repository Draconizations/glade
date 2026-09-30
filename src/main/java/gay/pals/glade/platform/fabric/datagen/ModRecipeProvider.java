package gay.pals.glade.platform.fabric.datagen;

//? fabric{
import java.util.concurrent.CompletableFuture;

import gay.pals.glade.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

public class ModRecipeProvider extends FabricRecipeProvider {
	public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void buildRecipes(RecipeOutput recipeExporter) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MAGENTA_DYE, 2)
				.requires(ModItems.FOXGLOVE)
				.unlockedBy(FabricRecipeProvider.getHasName(ModItems.FOXGLOVE), FabricRecipeProvider.has(ModItems.FOXGLOVE))
				.save(recipeExporter);
	}
}
//?}
