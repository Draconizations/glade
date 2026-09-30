package gay.pals.glade.platform.fabric.datagen;

//? fabric {
import gay.pals.glade.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;

public class ModModelProvider extends FabricModelProvider {
	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
		blockStateModelGenerator.createCrossBlockWithDefaultItem(ModBlocks.NETTLE, BlockModelGenerators.TintState.TINTED);
		blockStateModelGenerator.createDoublePlant(ModBlocks.LARGE_NETTLE, BlockModelGenerators.TintState.TINTED);
		blockStateModelGenerator.createDoublePlant(ModBlocks.FOXGLOVE, BlockModelGenerators.TintState.NOT_TINTED);

		blockStateModelGenerator.createFlowerBed(ModBlocks.CLOVERS);
	}

	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerator) {
	}

	@Override
	public String getName() {
		return "FernStoneBlockModelProvider";
	}
}
//?}
