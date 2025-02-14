package show.tatd.mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import show.tatd.mod.init.ModBlock;
import show.tatd.mod.init.ModItem;

public class TrailAndTalesDelightModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.BUDDING_LANTERN_FRUIT_CROP, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.LANTERN_FRUIT_CROP, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.BUDDING_LANTERN_FRUIT_CROP, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.SNIFFER_EGGSHELL, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.COOKED_SNIFFER_EGG_BLOCK, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlock.STUFFED_SNIFFER_EGG_BLOCK, RenderLayer.getTranslucent());
	}
}