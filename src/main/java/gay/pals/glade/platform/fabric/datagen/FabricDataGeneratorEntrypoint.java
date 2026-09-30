package gay.pals.glade.platform.fabric.datagen;

//? fabric {
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;

public class FabricDataGeneratorEntrypoint implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		final FabricDataGenerator.Pack pack = generator.createPack();
		pack.addProvider(ModModelProvider::new);

		pack.addProvider((FabricDataOutput output) -> new ModRecipeProvider(output, generator.getRegistries()));
		pack.addProvider((FabricDataOutput output) -> new ModBlockLootProvider(output, generator.getRegistries()));

		pack.addProvider((FabricDataOutput output) -> new ModItemTagProvider(output, generator.getRegistries()));
		pack.addProvider((FabricDataOutput output) -> new ModBlockTagProvider(output, generator.getRegistries()));

		pack.addProvider((FabricDataOutput output) -> new ModEnglishLangProvider(output, generator.getRegistries()));
	}
}
//?}
