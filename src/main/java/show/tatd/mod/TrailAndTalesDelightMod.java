package show.tatd.mod;

import net.fabricmc.api.ModInitializer;
import show.tatd.mod.init.ModBlock;
import show.tatd.mod.init.ModItem;
import show.tatd.mod.init.ModTab;
import show.tatd.mod.util.AddValidBlockUtil;
import vectorwing.farmersdelight.common.registry.ModBlockEntityTypes;

public class TrailAndTalesDelightMod implements ModInitializer {
	public static final String MOD_ID = "trailandtales_delight";

	@Override
	public void onInitialize() {
		ModItem.init();
		ModTab.init();
		ModBlock.init();
		AddValidBlockUtil.addBlock(ModBlockEntityTypes.STOVE.get(), ModBlock.MUD_STOVE);
		AddValidBlockUtil.addBlock(ModBlockEntityTypes.COOKING_POT.get(), ModBlock.POTTERY_COOKING_POT);
	}
}