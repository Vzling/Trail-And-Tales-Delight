package show.tatd.mod;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import show.tatd.mod.init.ModBlock;
import show.tatd.mod.init.ModItem;
import show.tatd.mod.init.ModTab;
import show.tatd.mod.util.AddValidBlockUtil;
import vectorwing.farmersdelight.common.registry.ModBlockEntityTypes;

@Mod(TrailAndTalesDelightMod.MOD_ID)
@EventBusSubscriber(modid = TrailAndTalesDelightMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class TrailAndTalesDelightMod {
    public static final String MOD_ID = "trailandtales_delight";
    //public static final Rarity ANCIENT = Rarity.valueOf("ANCIENT");
    public TrailAndTalesDelightMod(IEventBus modbus) {
        ModItem.ITEMS.register(modbus);
        ModTab.TABS.register(modbus);
        ModBlock.BLOCKS.register(modbus);
    }
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AddValidBlockUtil.addBlock(ModBlockEntityTypes.STOVE.get(), ModBlock.MUD_STOVE.get());
            AddValidBlockUtil.addBlock(ModBlockEntityTypes.COOKING_POT.get(), ModBlock.POTTERY_COOKING_POT.get());
        });
    }
}
