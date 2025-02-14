package show.tatd.mod.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import show.tatd.mod.TrailAndTalesDelightMod;

public class ModTab {
    public static final RegistryKey<ItemGroup> TABS = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(TrailAndTalesDelightMod.MOD_ID, "item"));

    public static final ItemGroup MOD_TAB = FabricItemGroup.builder()
            .displayName(Text.translatable("ItemGroup.trailandtales_delight.item"))
            .icon(() -> new ItemStack(ModItem.MUD_STOVE)).build();

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, TABS, MOD_TAB);
        ItemGroupEvents.modifyEntriesEvent(TABS).register(itemGroup -> {
            itemGroup.add(ModItem.MUD_STOVE);
            itemGroup.add(ModItem.POTTERY_COOKING_POT);
            itemGroup.add(ModItem.LANTERN_FRUIT_CRATE);
            itemGroup.add(ModItem.PITCHER_TARO_CRATE);
            itemGroup.add(ModItem.POTTERY_BOWL);
            itemGroup.add(ModItem.CHERRY_IRON_KNIFE);
            itemGroup.add(ModItem.SNIFFER_EGGSHELL_KNIFE);
            itemGroup.add(ModItem.BAKED_TORCHFLOWER_SEEDS);
            itemGroup.add(ModItem.CHERRY_PETAL);
            itemGroup.add(ModItem.DRIED_CHERRY_PETAL);
            itemGroup.add(ModItem.BAKED_PITCHER_POD);
            itemGroup.add(ModItem.PITCHER_PLANT);
            itemGroup.add(ModItem.TARO);
            itemGroup.add(ModItem.COOKED_TARO);
            itemGroup.add(ModItem.LANTERN_FRUIT);
            itemGroup.add(ModItem.GOLDEN_LANTERN_FRUIT);
            itemGroup.add(ModItem.LANTERN_FRUIT_SEEDS);
            itemGroup.add(ModItem.FRIED_SNIFFER_EGG);
            itemGroup.add(ModItem.ANCIENT_COFFEE);
            itemGroup.add(ModItem.TORCHFLOWER_TEA);
            itemGroup.add(ModItem.CHERRY_PETAL_TEA);
            itemGroup.add(ModItem.PITCHER_PLANT_TEA);
            itemGroup.add(ModItem.CURD_BLOCK);
            itemGroup.add(ModItem.CHERRY_CAKE);
            itemGroup.add(ModItem.CHERRY_CHEESE_PIE);
            itemGroup.add(ModItem.CHEESE_WHEEL);
            itemGroup.add(ModItem.CHERRY_CAKE_SLICE);
            itemGroup.add(ModItem.CHERRY_CHEESE_PIE_SLICE);
            itemGroup.add(ModItem.CHEESE_SLICE);
            itemGroup.add(ModItem.CHERRY_CHEESE_SLICE);
            itemGroup.add(ModItem.SNIFFER_EGGSHELL);
            itemGroup.add(ModItem.COOKED_SNIFFER_EGG_BLOCK);
            itemGroup.add(ModItem.STUFFED_SNIFFER_EGG_BLOCK);
            itemGroup.add(ModItem.STUFFED_SNIFFER_EGG);
        });
    }
}
