package gay.pals.glade.platform.fabric;

//? fabric {

import gay.pals.glade.Glade;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;

@Entrypoint("client")
public class FabricClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		Glade.onInitializeClient();
	}

}
//?}
