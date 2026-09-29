package gay.pals.glade.registry;

import gay.pals.glade.Glade;
import gay.pals.glade.block.LargeNettleBlock;
import gay.pals.glade.block.NettleBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.function.Function;

public class ModBlocks {
	public static ArrayList<Block> GRASS_TINTED_BLOCKS = new ArrayList<>();

	public static void register() {
		Glade.LOGGER.debug("Registering Glade's ModBlocks!");
	}

	// PLANTS
	public static NettleBlock NETTLE = registerGrassTintedBlock("nettle", NettleBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS));
	public static LargeNettleBlock LARGE_NETTLE = registerGrassTintedBlock("large_nettle", LargeNettleBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS));

	public static <T extends Block> T registerGrassTintedBlock(String id, Function<BlockBehaviour.Properties, T> factory, BlockBehaviour.Properties settings) {
		var entry = registerBlock(id, factory, settings);
		GRASS_TINTED_BLOCKS.add(entry);
		return entry;
	}

	public static <T extends Block> T registerBlock(String id, Function<BlockBehaviour.Properties, T> factory, BlockBehaviour.Properties settings) {
		ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, Glade.id(id));
		T block = factory.apply(settings);
		var entry = Registry.register(BuiltInRegistries.BLOCK, key, block);
		return entry;
	}
}
