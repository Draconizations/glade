package gay.pals.glade;

import gay.pals.glade.platform.Platform;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//? fabric {
import gay.pals.glade.platform.fabric.FabricPlatform;
//?} neoforge {
/*import gay.pals.glade.platform.neoforge.NeoforgePlatform;
 *///?}

@SuppressWarnings("LoggingSimilarMessage")
public class Glade {

	public static final String MOD_ID = /*$ mod_id*/ "glade";
	public static final String MOD_VERSION = /*$ mod_version*/ "0.1.0";
	public static final String MOD_FRIENDLY_NAME = /*$ mod_name*/ "Glade";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Platform PLATFORM = createPlatformInstance();

	public static void onInitialize() {
		LOGGER.info("Initializing {} on {}", MOD_ID, Glade.xplat().loader());
		LOGGER.debug("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);
	}

	public static void onInitializeClient() {
		LOGGER.info("Initializing {} Client on {}", MOD_ID, Glade.xplat().loader());
		LOGGER.debug("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);
	}

	public static Platform xplat() {
		return PLATFORM;
	}

	private static Platform createPlatformInstance() {
		//? fabric {
		return new FabricPlatform();
		//?} neoforge {
		/*return new NeoforgePlatform();
		 *///?} forge {
		/*return new ForgePlatform();
		 *///?}
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	public static ResourceLocation id(String namespace, String path) {
		return ResourceLocation.fromNamespaceAndPath(namespace, path);
	}
}
