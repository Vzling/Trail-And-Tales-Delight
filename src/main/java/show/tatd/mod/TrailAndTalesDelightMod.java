package show.tatd.mod;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import show.tatd.mod.init.ModBlock;
import show.tatd.mod.init.ModItem;
import show.tatd.mod.init.ModTab;
import show.tatd.mod.util.AddValidBlockUtil;
import vectorwing.farmersdelight.common.registry.ModBlockEntityTypes;


import java.util.AbstractMap;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

@Mod(TrailAndTalesDelightMod.MOD_ID)
@Mod.EventBusSubscriber(modid = TrailAndTalesDelightMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TrailAndTalesDelightMod {
    public static final String MOD_ID = "trailandtales_delight";
    public static final Rarity ANCIENT = Rarity.create("ANCIENT", ChatFormatting.GOLD);
    public TrailAndTalesDelightMod() {
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
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
