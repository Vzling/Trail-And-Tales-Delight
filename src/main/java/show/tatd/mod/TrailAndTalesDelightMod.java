package show.tatd.mod;

import io.github.fabricators_of_create.porting_lib.util.DeferredHolder;
import io.github.fabricators_of_create.porting_lib.util.DeferredRegister;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.entity.BlockEntityType;
import show.tatd.mod.init.ModBlock;
import show.tatd.mod.init.ModItem;
import show.tatd.mod.init.ModTab;
import show.tatd.mod.util.AddValidBlockUtil;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.registry.ModBlockEntityTypes;

public class TrailAndTalesDelightMod implements ModInitializer {
    public static final String MOD_ID = "trailandtales_delight";

    @Override
    public void onInitialize() {
        ModItem.init();
        ModTab.init();
        ModBlock.init();
        if (FabricLoader.getInstance().isModLoaded(FarmersDelight.MODID)) {
            AddValidBlockUtil.addBlock(ModBlockEntityTypes.STOVE.get(), ModBlock.MUD_STOVE);
            AddValidBlockUtil.addBlock(ModBlockEntityTypes.COOKING_POT.get(), ModBlock.POTTERY_COOKING_POT);
        }
    }
}