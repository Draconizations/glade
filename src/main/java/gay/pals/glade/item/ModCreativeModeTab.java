package gay.pals.glade.item;

import gay.pals.glade.Glade;
import gay.pals.glade.registry.ModItems;
//? fabric
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;

public class ModCreativeModeTab {
	public static final ResourceKey<CreativeModeTab> MAIN_TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Glade.id("main_group"));
	public static final CreativeModeTab MAIN_TAB =
			//? fabric
			FabricItemGroup
					//? neoforge
					//CreativeModeTab
					.builder().icon(()-> ModItems.NETTLE.getDefaultInstance()).title(Component.translatable("itemGroup.glade.main_group")).displayItems(((itemDisplayParameters, output) -> {
						for (Item item : ModItems.ITEMS) {
							output.accept(item);
						}
					})).build();

	public static void register() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MAIN_TAB_KEY, MAIN_TAB);
	}
}
