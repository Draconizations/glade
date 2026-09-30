package gay.pals.glade.registry;

import gay.pals.glade.Glade;
import gay.pals.glade.block.LargeNettleBlock;
import gay.pals.glade.block.NettleBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.function.Function;

public class ModBlocks {
	public static ArrayList<Block> GRASS_TINTED_BLOCKS = new ArrayList<>();
	public static ArrayList<Block> CUTOUT_BLOCKS = new ArrayList<>();

	// PLANTS
	public static NettleBlock NETTLE = registerBlock("nettle", NettleBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS));
	public static LargeNettleBlock LARGE_NETTLE = registerBlock("large_nettle", LargeNettleBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS));
	public static TallFlowerBlock FOXGLOVE = registerBlock("foxglove", TallFlowerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PEONY).mapColor(DyeColor.MAGENTA));

	public static PinkPetalsBlock CLOVERS = registerBlock("clovers", PinkPetalsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_PETALS));


	public static void register() {
		Glade.LOGGER.debug("Registering Glade's ModBlocks!");

		GRASS_TINTED_BLOCKS.add(NETTLE);
		GRASS_TINTED_BLOCKS.add(LARGE_NETTLE);

		CUTOUT_BLOCKS.addAll(GRASS_TINTED_BLOCKS);
		CUTOUT_BLOCKS.add(FOXGLOVE);
		CUTOUT_BLOCKS.add(CLOVERS);
	}

	public static <T extends Block> T registerBlock(String id, Function<BlockBehaviour.Properties, T> factory, BlockBehaviour.Properties settings) {
		ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, Glade.id(id));
		T block = factory.apply(settings);
		return Registry.register(BuiltInRegistries.BLOCK, key, block);
	}
}
