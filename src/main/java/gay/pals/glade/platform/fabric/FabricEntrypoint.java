package gay.pals.glade.platform.fabric;

//? fabric {

import gay.pals.glade.Glade;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import gay.pals.glade.item.ModCreativeModeTab;
import gay.pals.glade.registry.ModBlocks;
import gay.pals.glade.registry.ModItems;
import net.fabricmc.api.ModInitializer;

@Entrypoint("main")
public class FabricEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		Glade.onInitialize();
		FabricEventSubscriber.registerEvents();

		ModBlocks.register();
		ModItems.register();
		ModCreativeModeTab.register();
	}
}
//?}
