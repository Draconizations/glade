package gay.pals.glade.registry;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.function.BiConsumer;

import static gay.pals.glade.registry.ModBlocks.GRASS_TINTED_BLOCKS;
import static gay.pals.glade.registry.ModItems.GRASS_TINTED_ITEMS;

public class ModColorProvider {
	public static void registerBlockColors(BiConsumer<BlockColor, Block[]> consumer) {
		consumer.accept(
					(state, view, pos, tintIndex) -> BiomeColors.getAverageGrassColor(view, pos),
					GRASS_TINTED_BLOCKS.toArray(Block[]::new)
					);
	}

	public static void registerItemColors(BiConsumer<ItemColor, ItemLike[]> consumer) {
		consumer.accept(
				(item, tintIndex) -> GrassColor.getDefaultColor(),
				GRASS_TINTED_ITEMS.toArray(ItemLike[]::new)
		);
	}
}
