package show.tatd.mod.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import show.tatd.mod.TrailAndTalesDelightMod;
import show.tatd.mod.block.*;
import vectorwing.farmersdelight.common.block.*;

public class ModBlock {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TrailAndTalesDelightMod.MOD_ID);
    //Feast Food
    public static final RegistryObject<Block> COOKED_SNIFFER_EGG_BLOCK = BLOCKS.register("cooked_sniffer_egg_block",
            () -> new CookedSnifferEggBlock(BlockBehaviour.Properties.copy(Blocks.SNIFFER_EGG),
                    ModItem.FRIED_SNIFFER_EGG,
                    true));

    public static final RegistryObject<Block> STUFFED_SNIFFER_EGG_BLOCK = BLOCKS.register("stuffed_sniffer_egg_block",
            () -> new StuffedSnifferEggBlock(BlockBehaviour.Properties.copy(Blocks.SNIFFER_EGG),
                    ModItem.STUFFED_SNIFFER_EGG,
                    true));

    //Cake&Pie
    public static final RegistryObject<Block> CHERRY_CHEESE_PIE = BLOCKS.register("cherry_cheese_pie",
        () -> new PieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE),
                ModItem.CHERRY_CHEESE_PIE_SLICE));

    public static final RegistryObject<Block> CHERRY_CAKE = BLOCKS.register("cherry_cake",
            () -> new CherryCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE),
                    ModItem.CHERRY_CAKE_SLICE));

    public static final RegistryObject<Block> CHEESE_WHEEL = BLOCKS.register("cheese_wheel",
            () -> new CheeseBlock(BlockBehaviour.Properties.copy(Blocks.HONEY_BLOCK).strength(0.5F, 6.0F),
                    ModItem.CHEESE_SLICE));

    //Crop
    public static final RegistryObject<Block> BUDDING_LANTERN_FRUIT_CROP = BLOCKS.register("budding_lantern_fruit",
            () -> new BuddingLanternFruitBlock(Block.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> LANTERN_FRUIT_CROP = BLOCKS.register("lantern_fruits",
            () -> new LanternFruitVineBlock(Block.Properties.copy(Blocks.WHEAT)));

    //Tool
    public static final RegistryObject<Block> POTTERY_COOKING_POT = BLOCKS.register("pottery_cooking_pot",
            () -> new CookingPotBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT)
                    .strength(0.2F, 6.0F)
                    .sound(SoundType.DECORATED_POT)));

    public static final RegistryObject<Block> MUD_STOVE = BLOCKS.register("mud_stove", MudStoveBlock::new);

    //Crate
    public static final RegistryObject<Block> LANTERN_FRUIT_CRATE = BLOCKS.register("lantern_fruit_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PITCHER_TARO_CRATE = BLOCKS.register("pitcher_taro_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)));

    //Basic Block
    public static final RegistryObject<Block> SNIFFER_EGGSHELL = BLOCKS.register("sniffer_eggshell",
            () -> new SnifferEggshell(BlockBehaviour.Properties.copy(Blocks.SNIFFER_EGG)));

    public static final RegistryObject<Block> CURD_BLOCK = BLOCKS.register("curd_block",
            () -> new CurdBlock(BlockBehaviour.Properties.copy(Blocks.HONEY_BLOCK).strength(0.5F, 6.0F)));


}
