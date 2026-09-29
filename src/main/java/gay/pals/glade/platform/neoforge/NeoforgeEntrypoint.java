package gay.pals.glade.platform.neoforge;

//? neoforge {

/*import gay.pals.glade.Glade;
import gay.pals.glade.item.ModCreativeModeTab;
import gay.pals.glade.registry.ModBlocks;
import gay.pals.glade.registry.ModColorProvider;
import gay.pals.glade.registry.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

import static gay.pals.glade.registry.ModBlocks.CUTOUT_BLOCKS;

@Mod(Glade.MOD_ID)
public class NeoforgeEntrypoint {

	public NeoforgeEntrypoint(IEventBus eventBus, ModContainer container) {
		Glade.onInitialize();

		eventBus.addListener(NeoforgeEntrypoint::onRegister);
		eventBus.addListener((RegisterColorHandlersEvent.Block event) -> ModColorProvider.registerBlockColors(event::register));
		eventBus.addListener((RegisterColorHandlersEvent.Item event) -> ModColorProvider.registerItemColors(event::register));
		eventBus.addListener(NeoforgeEntrypoint::onClientSetup);
	}

	public static void onRegister(RegisterEvent event) {
		if (event.getRegistryKey().equals(Registries.BLOCK)) {
			ModBlocks.register();
		} else if (event.getRegistryKey().equals(Registries.ITEM)) {
			ModItems.register();
			ModCreativeModeTab.register();
		}
	}

	public static void onClientSetup(FMLClientSetupEvent event) {
		CUTOUT_BLOCKS.forEach((block) -> ItemBlockRenderTypes.setRenderLayer(block, RenderType.cutout()));
	}
}
*///?}
