package gay.pals.glade.platform.fabric.datagen;

//? fabric {
import gay.pals.glade.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider wrapperLookup) {
		getOrCreateTagBuilder(BlockTags.REPLACEABLE).add(ModBlocks.NETTLE, ModBlocks.LARGE_NETTLE);
		getOrCreateTagBuilder(BlockTags.REPLACEABLE_BY_TREES).add(ModBlocks.NETTLE, ModBlocks.LARGE_NETTLE);
		getOrCreateTagBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(ModBlocks.CLOVERS);
	}
}
//?}
