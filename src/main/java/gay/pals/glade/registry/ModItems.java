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
	public static ArrayList<Item> ITEMS = new ArrayList<>();
	public static ArrayList<Item> GRASS_TINTED_ITEMS = new ArrayList<>();

	// Plants
	public static Item NETTLE = registerBlockItem("nettle", ModBlocks.NETTLE);
	public static Item LARGE_NETTLE = registerBlockItem("large_nettle", ModBlocks.LARGE_NETTLE);
	public static Item FOXGLOVE = registerBlockItem("foxglove", ModBlocks.FOXGLOVE);

	public static Item CLOVERS = registerBlockItem("clovers", ModBlocks.CLOVERS);


	public static void register() {
		Glade.LOGGER.debug("Registering ModItems!");

		GRASS_TINTED_ITEMS.add(NETTLE);
		GRASS_TINTED_ITEMS.add(LARGE_NETTLE);
	}

	private static Item registerItem(String name) {
		return registerItem(name, Item::new, false);
	}

	public static BlockItem registerBlockItem(String id, Block block) {
		return registerBlockItem(id, block, false);
	}

	public static BlockItem registerBlockItem(String id, Block block, boolean hideFromCreative) {
		return registerItem(id, (properties)-> new BlockItem(block, properties), new Item.Properties(), hideFromCreative);
	}

	private static <T extends Item> T registerItem(String id, Function<Item.Properties, T> factory, boolean hideFromCreative) {
		return registerItem(id, factory, new Item.Properties(), hideFromCreative);
	}

	protected static <T extends Item> T registerItem(String id, Function<Item.Properties, T> factory, Item.Properties settings, boolean hideFromCreative) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Glade.id(id));
		T block = factory.apply(settings);
		var entry = Registry.register(BuiltInRegistries.ITEM, key, block);
		if (!hideFromCreative)
			ITEMS.add(entry);
		return entry;
	}
}
