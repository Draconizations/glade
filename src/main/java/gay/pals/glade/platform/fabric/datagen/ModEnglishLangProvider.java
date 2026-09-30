package gay.pals.glade.platform.fabric.datagen;

//? fabric {
import gay.pals.glade.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLangProvider extends FabricLanguageProvider {
	public ModEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
		// Specifying en_us is optional, as it's the default language code
		super(dataOutput, "en_us", registryLookup);
	}

	@Override
	public void generateTranslations(HolderLookup.Provider holderLookup, TranslationBuilder translationBuilder) {
		translationBuilder.add(ModBlocks.NETTLE, "Nettle");
		translationBuilder.add(ModBlocks.LARGE_NETTLE, "Large Nettle");
		translationBuilder.add(ModBlocks.CLOVERS, "Clovers");
		translationBuilder.add(ModBlocks.FOXGLOVE, "Foxglove");

		translationBuilder.add("itemGroup.glade.main_group", "Glade");
	}
}
//?}
