//? fabric {
package gay.pals.glade.platform.fabric.datagen;

import gay.pals.glade.registry.ModBlocks;
import gay.pals.glade.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootProvider extends FabricBlockLootTableProvider {
	public ModBlockLootProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(dataOutput, registryLookup);
	}

	@Override
	public void generate() {
		add(ModBlocks.NETTLE, BlockLootSubProvider.createShearsOnlyDrop(ModItems.NETTLE));
		add(ModBlocks.LARGE_NETTLE, this::createDoublePlantShearsDrop);
		add(ModBlocks.CLOVERS, this.createPetalsDrops(ModBlocks.CLOVERS));
	}
}
//?}
