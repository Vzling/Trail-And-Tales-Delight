package show.tatd.mod.init;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import show.tatd.mod.TATDFoodValues;
import show.tatd.mod.TrailAndTalesDelightMod;
import show.tatd.mod.item.CherryIronKnife;
import show.tatd.mod.item.PitcherPlant;
import show.tatd.mod.item.SnifferEggshellKnife;
import show.tatd.mod.item.TATDConsumableItem;
import vectorwing.farmersdelight.common.item.CookingPotItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static vectorwing.farmersdelight.common.registry.ModItems.basicItem;

public class ModItem {
    //Feast Food
    public static final BlockItem COOKED_SNIFFER_EGG_BLOCK = (BlockItem) register("cooked_sniffer_egg_block", new BlockItem(ModBlock.COOKED_SNIFFER_EGG_BLOCK, basicItem().maxCount(1)));

    public static final BlockItem STUFFED_SNIFFER_EGG_BLOCK = (BlockItem) register("stuffed_sniffer_egg_block", new BlockItem(ModBlock.STUFFED_SNIFFER_EGG_BLOCK, basicItem().maxCount(1)));

    //Feast Portions
    public static final Item STUFFED_SNIFFER_EGG = register("stuffed_sniffer_egg",
            new TATDConsumableItem(bowlFoodItem(TATDFoodValues.STUFFED_SNIFFER_EGG), true));

    //Cake&Pie
    public static final Item CHERRY_CHEESE_PIE = register("cherry_cheese_pie",
            new BlockItem(ModBlock.CHERRY_CHEESE_PIE, basicItem()
            ));

    public static final Item CHERRY_CAKE = register("cherry_cake",
            new BlockItem(ModBlock.CHERRY_CAKE, basicItem().maxCount(1)
            ));

    public static final Item CHEESE_WHEEL = register("cheese_wheel",
            new BlockItem(ModBlock.CHEESE_WHEEL, basicItem()
            ));

    //Cake&Pie Slice
    public static final Item CHERRY_CHEESE_PIE_SLICE = register("cherry_cheese_pie_slice",
            new TATDConsumableItem(foodItem(TATDFoodValues.CHEESE_PIE_SLICE),
                    true));

    public static final Item CHERRY_CAKE_SLICE = register("cherry_cake_slice",
            new TATDConsumableItem(foodItem(TATDFoodValues.CHERRY_CAKE_SLICE),
                    true));

    public static final Item CHEESE_SLICE = register("cheese_slice",
            new TATDConsumableItem(foodItem(TATDFoodValues.CHEESE_SLICE),
                    false));
    public static final Item CHERRY_CHEESE_SLICE = register("cherry_cheese_slice",
            new TATDConsumableItem(foodItem(TATDFoodValues.CHERRY_CHEESE_SLICE),
                    true));

    //Crop
    public static final Item LANTERN_FRUIT_SEEDS = register("lantern_fruit_seeds",
            new AliasedBlockItem(ModBlock.BUDDING_LANTERN_FRUIT_CROP, basicItem()));

    //Tool
    public static final Item POTTERY_COOKING_POT = register("pottery_cooking_pot",
            new CookingPotItem(ModBlock.POTTERY_COOKING_POT, basicItem()
                    .maxCount(1)));

    public static final BlockItem MUD_STOVE = (BlockItem) register("mud_stove",
            new BlockItem(ModBlock.MUD_STOVE, new Item.Settings()
                    ));

    //Crate
    public static final Item LANTERN_FRUIT_CRATE = register("lantern_fruit_crate",
            new BlockItem(ModBlock.LANTERN_FRUIT_CRATE, basicItem()));

    public static final Item PITCHER_TARO_CRATE = register("pitcher_taro_crate",
            new BlockItem(ModBlock.PITCHER_TARO_CRATE, basicItem()));

    //Knives
    public static final Item CHERRY_IRON_KNIFE = register("cherry_iron_knife", new CherryIronKnife());

    public static final Item SNIFFER_EGGSHELL_KNIFE = register("sniffer_eggshell_knife", new SnifferEggshellKnife());

    //Basic Block
    public static final BlockItem SNIFFER_EGGSHELL = (BlockItem) register("sniffer_eggshell",
            new BlockItem(ModBlock.SNIFFER_EGGSHELL, basicItem()
            ));

    public static final BlockItem CURD_BLOCK = (BlockItem) register("curd_block",
            new BlockItem(ModBlock.CURD_BLOCK, basicItem()
            ));

    //Basic Food
    public static final Item FRIED_SNIFFER_EGG = register("fried_sniffer_egg",
            new TATDConsumableItem(foodItem(TATDFoodValues.FRIED_SNIFFER_EGG),
                    false));

    public static final Item BAKED_PITCHER_POD = register("baked_pitcher_pod",
            new TATDConsumableItem(foodItem(TATDFoodValues.PITCHER_POD),
                    true));

    public static final Item BAKED_TORCHFLOWER_SEEDS = register("baked_torchflower_seeds",
            new TATDConsumableItem(foodItem(TATDFoodValues.TORCHFLOWER_SEEDS),
                    true));

    public static final Item TARO = register("pitcher_taro",
            new TATDConsumableItem(foodItem(TATDFoodValues.TARO),
                    true));

    public static final Item COOKED_TARO = register("cooked_pitcher_taro",
            new TATDConsumableItem(foodItem(TATDFoodValues.COOKED_TARO),
                    true));


    //Drink
    public static final Item ANCIENT_COFFEE = register("ancient_coffee",
            new DrinkableItem(drinkItem(TATDFoodValues.ANCIENT_COFFEE).rarity(Rarity.UNCOMMON)/*.rarity(TrailAndTalesDelightMod.ANCIENT)*/,
                    true, false));
    public static final Item PITCHER_PLANT_TEA = register("pitcher_plant_tea",
            new DrinkableItem(drinkItem(TATDFoodValues.PITCHER_PLANT_TEA),
                    true, false));
    public static final Item TORCHFLOWER_TEA = register("torchflower_tea",
            new DrinkableItem(drinkItem(TATDFoodValues.TORCHFLOWER_TEA),
                    true, false));
    public static final Item CHERRY_PETAL_TEA = register("cherry_petal_tea",
            new DrinkableItem(drinkItem(TATDFoodValues.CHERRY_PETAL_TEA),
                    true, false));
    //Fruit
    public static final Item LANTERN_FRUIT = register("lantern_fruit",
            new TATDConsumableItem(foodItem(TATDFoodValues.LANTERN_FRUIT),
                    true));

    public static final Item GOLDEN_LANTERN_FRUIT = register("golden_lantern_fruit",
            new TATDConsumableItem(foodItem(TATDFoodValues.GOLDEN_LANTERN_FRUIT).rarity(Rarity.RARE),
                    true));

    //Basic Item
    public static final Item POTTERY_BOWL = register("pottery_bowl",
            new Item(new Item.Settings()));

    public static final Item CHERRY_PETAL = register("cherry_petal",
            new Item(new Item.Settings()));

    public static final Item DRIED_CHERRY_PETAL = register("dried_cherry_petal",
            new Item(new Item.Settings()));

    public static final Item PITCHER_PLANT = register("pitcher_plant",
            new PitcherPlant(new Item.Settings()));

    public static Item.Settings bowlFoodItem(FoodComponent food) {
        return new Item.Settings()
                .food(food)
                .recipeRemainder(Items.BOWL)
                .maxCount(16);
    }
    public static Item.Settings drinkItem(FoodComponent food) {
        return new Item.Settings()
                .food(food)
                .recipeRemainder(Items.GLASS_BOTTLE)
                .maxCount(16);
    }
    public static Item.Settings stickFoodItem(FoodComponent food) {
        return new Item.Settings()
                .food(food)
                .recipeRemainder(Items.STICK)
                .maxCount(16);
    }
    public static Item.Settings foodItem(FoodComponent food) {
        return new Item.Settings()
                .food(food);
    }
    
    public static Item register(String path, Item item) {
        return Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TrailAndTalesDelightMod.MOD_ID, path)).getValue(), item);
    }

    public static void init() {
    }
}
