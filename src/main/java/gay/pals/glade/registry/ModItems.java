package gay.pals.glade.registry;

import gay.pals.glade.Glade;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.function.Function;

public class ModItems {
	public static void register() {
		Glade.LOGGER.debug("Registering ModItems!");
	}

	public static ArrayList<Item> ITEMS = new ArrayList<>();
	public static ArrayList<Item> GRASS_TINTED_ITEMS = new ArrayList<>();

	// Plants
	public static Item NETTLE = registerGrassTintedBlockItem("nettle", ModBlocks.NETTLE);
	public static Item LARGE_NETTLE = registerGrassTintedBlockItem("large_nettle", ModBlocks.LARGE_NETTLE);

	private static Item registerItem(String name) {
		return registerItem(name, Item::new, false);
	}

	private static Item registerGrassTintedBlockItem(String name, Block block) {
		var entry = registerBlockItem(name, block, false);
		GRASS_TINTED_ITEMS.add(entry);
		return entry;
	}

	protected static <T extends Item> T registerItem(String id, Function<Item.Properties, T> factory, Item.Properties settings, boolean hidden) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Glade.id(id));
		T block = factory.apply(settings);
		var entry = Registry.register(BuiltInRegistries.ITEM, key, block);
		if (!hidden)
			ITEMS.add(entry);
		return entry;
	}

	public static BlockItem registerBlockItem(String id, Block block) {
		return registerItem(id, (properties)-> new BlockItem(block, properties), new Item.Properties(), false);
	}


	public static BlockItem registerBlockItem(String id, Block block, boolean hideFromCreative) {
		return registerItem(id, (properties)-> new BlockItem(block, properties), new Item.Properties(), hideFromCreative);
	}

	private static <T extends Item> T registerItem(String id, Function<Item.Properties, T> factory, boolean hidden) {
		return registerItem(id, factory, new Item.Properties(), hidden);
	}
}
