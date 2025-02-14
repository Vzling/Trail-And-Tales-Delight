package show.tatd.mod.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import show.tatd.mod.TrailAndTalesDelightMod;
import show.tatd.mod.block.*;
import vectorwing.farmersdelight.common.block.CookingPotBlock;
import vectorwing.farmersdelight.common.block.PieBlock;

public class ModBlock {
    //Feast Food
    public static final Block COOKED_SNIFFER_EGG_BLOCK = register("cooked_sniffer_egg_block",
            new CookedSnifferEggBlock(AbstractBlock.Settings.copy(Blocks.SNIFFER_EGG),
                    () -> ModItem.FRIED_SNIFFER_EGG,
                    true));

    public static final Block STUFFED_SNIFFER_EGG_BLOCK = register("stuffed_sniffer_egg_block",
            new StuffedSnifferEggBlock(AbstractBlock.Settings.copy(Blocks.SNIFFER_EGG),
                    () -> ModItem.STUFFED_SNIFFER_EGG,
                    true));

    //Cake&Pie
    public static final Block CHERRY_CHEESE_PIE = register("cherry_cheese_pie",
            new PieBlock(AbstractBlock.Settings.copy(Blocks.CAKE),
                    () -> ModItem.CHERRY_CHEESE_PIE_SLICE));

    public static final Block CHERRY_CAKE = register("cherry_cake",
            new CherryCakeBlock(AbstractBlock.Settings.copy(Blocks.CAKE),
                    () -> ModItem.CHERRY_CAKE_SLICE));

    public static final Block CHEESE_WHEEL = register("cheese_wheel",
            new CheeseBlock(AbstractBlock.Settings.copy(Blocks.HONEY_BLOCK).strength(0.5F, 6.0F),
                    () -> ModItem.CHEESE_SLICE));

    //Crop
    public static final Block BUDDING_LANTERN_FRUIT_CROP = register("budding_lantern_fruit",
            new BuddingLanternFruitBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    public static final Block LANTERN_FRUIT_CROP = register("lantern_fruits",
            new LanternFruitVineBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    //Tool
    public static final Block POTTERY_COOKING_POT = register("pottery_cooking_pot",
            new CookingPotBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DIRT_BROWN)
                    .strength(0.2F, 6.0F)
                    .sounds(BlockSoundGroup.DECORATED_POT)));

    public static final Block MUD_STOVE = register("mud_stove", new MudStoveBlock());

    //Crate
    public static final Block LANTERN_FRUIT_CRATE = register("lantern_fruit_crate",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block PITCHER_TARO_CRATE = register("pitcher_taro_crate",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)));

    //Basic Block
    public static final Block SNIFFER_EGGSHELL = register("sniffer_eggshell",
            new SnifferEggshell(AbstractBlock.Settings.copy(Blocks.SNIFFER_EGG)));

    public static final Block CURD_BLOCK = register("curd_block",
            new CurdBlock(AbstractBlock.Settings.copy(Blocks.HONEY_BLOCK).strength(0.5F, 6.0F)));

    public static Block register(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(TrailAndTalesDelightMod.MOD_ID, name), block);
    }

    public static void init() {
    }
}
