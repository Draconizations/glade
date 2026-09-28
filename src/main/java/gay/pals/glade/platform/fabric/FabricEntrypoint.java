package gay.pals.glade.platform.fabric;

//? fabric {

import gay.pals.glade.Glade;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ModInitializer;

@Entrypoint("main")
public class FabricEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		Glade.onInitialize();
		FabricEventSubscriber.registerEvents();
	}
}
//?}
