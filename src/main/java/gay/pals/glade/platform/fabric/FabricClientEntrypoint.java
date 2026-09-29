package gay.pals.glade.platform.fabric;

//? fabric {

import gay.pals.glade.Glade;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import gay.pals.glade.registry.ModColorProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.RenderType;

import static gay.pals.glade.registry.ModBlocks.CUTOUT_BLOCKS;

@Entrypoint("client")
public class FabricClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		Glade.onInitializeClient();

		ModColorProvider.registerBlockColors(ColorProviderRegistry.BLOCK::register);
		ModColorProvider.registerItemColors(ColorProviderRegistry.ITEM::register);
		CUTOUT_BLOCKS.forEach((block) -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout()));
	}

}
//?}
