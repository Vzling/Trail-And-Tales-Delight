package show.tatd.mod.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import show.tatd.mod.TrailAndTalesDelightMod;

public class ModTab {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TrailAndTalesDelightMod.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_TAB = TABS.register("item",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("ItemGroup.trailandtales_delight.item"))
                    .icon(() -> new ItemStack(ModItem.MUD_STOVE.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItem.MUD_STOVE.get());
                        output.accept(ModItem.POTTERY_COOKING_POT.get());
                        output.accept(ModItem.LANTERN_FRUIT_CRATE.get());
                        output.accept(ModItem.PITCHER_TARO_CRATE.get());
                        output.accept(ModItem.POTTERY_BOWL.get());
                        output.accept(ModItem.CHERRY_IRON_KNIFE.get());
                        output.accept(ModItem.SNIFFER_EGGSHELL_KNIFE.get());
                        output.accept(ModItem.BAKED_TORCHFLOWER_SEEDS.get());
                        output.accept(ModItem.CHERRY_PETAL.get());
                        output.accept(ModItem.DRIED_CHERRY_PETAL.get());
                        output.accept(ModItem.PITCHER_PLANT.get());
                        output.accept(ModItem.TARO.get());
                        output.accept(ModItem.COOKED_TARO.get());
                        output.accept(ModItem.LANTERN_FRUIT.get());
                        output.accept(ModItem.GOLDEN_LANTERN_FRUIT.get());
                        output.accept(ModItem.LANTERN_FRUIT_SEEDS.get());
                        output.accept(ModItem.FRIED_SNIFFER_EGG.get());
                        output.accept(ModItem.ANCIENT_COFFEE.get());
                        output.accept(ModItem.TORCHFLOWER_TEA.get());
                        output.accept(ModItem.CHERRY_PETAL_TEA.get());
                        output.accept(ModItem.PITCHER_PLANT_TEA.get());
                        output.accept(ModItem.CURD_BLOCK.get());
                        output.accept(ModItem.CHERRY_CAKE.get());
                        output.accept(ModItem.CHERRY_CHEESE_PIE.get());
                        output.accept(ModItem.CHEESE_WHEEL.get());
                        output.accept(ModItem.CHERRY_CAKE_SLICE.get());
                        output.accept(ModItem.CHERRY_CHEESE_PIE_SLICE.get());
                        output.accept(ModItem.CHEESE_SLICE.get());
                        output.accept(ModItem.CHERRY_CHEESE_SLICE.get());
                        output.accept(ModItem.SNIFFER_EGGSHELL.get());
                        output.accept(ModItem.COOKED_SNIFFER_EGG_BLOCK.get());
                        output.accept(ModItem.STUFFED_SNIFFER_EGG_BLOCK.get());
                        output.accept(ModItem.STUFFED_SNIFFER_EGG.get());
                    }).build());
}
