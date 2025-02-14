package show.tatd.mod.init;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import show.tatd.mod.TrailAndTalesDelightMod;
import show.tatd.mod.TATDFoodValues;
import show.tatd.mod.item.*;
import vectorwing.farmersdelight.common.item.CookingPotItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static vectorwing.farmersdelight.common.registry.ModItems.basicItem;

public class ModItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TrailAndTalesDelightMod.MOD_ID);
    //Feast Food
    public static final RegistryObject<BlockItem> COOKED_SNIFFER_EGG_BLOCK = ITEMS.register("cooked_sniffer_egg_block",
        () -> new BlockItem(ModBlock.COOKED_SNIFFER_EGG_BLOCK.get(), basicItem().stacksTo(1)
        ));

    public static final RegistryObject<BlockItem> STUFFED_SNIFFER_EGG_BLOCK = ITEMS.register("stuffed_sniffer_egg_block",
            () -> new BlockItem(ModBlock.STUFFED_SNIFFER_EGG_BLOCK.get(), basicItem().stacksTo(1)
            ));

    //Feast Portions
    public static final RegistryObject<Item> STUFFED_SNIFFER_EGG = ITEMS.register("stuffed_sniffer_egg",
            () -> new TATDConsumableItem(bowlFoodItem(TATDFoodValues.STUFFED_SNIFFER_EGG), true));

    //Cake&Pie
    public static final RegistryObject<Item> CHERRY_CHEESE_PIE = ITEMS.register("cherry_cheese_pie",
            () -> new BlockItem(ModBlock.CHERRY_CHEESE_PIE.get(), basicItem()
            ));

    public static final RegistryObject<Item> CHERRY_CAKE = ITEMS.register("cherry_cake",
            () -> new BlockItem(ModBlock.CHERRY_CAKE.get(), basicItem().stacksTo(1)
            ));

    public static final RegistryObject<Item> CHEESE_WHEEL = ITEMS.register("cheese_wheel",
            () -> new BlockItem(ModBlock.CHEESE_WHEEL.get(), basicItem()
            ));

    //Cake&Pie Slice
    public static final RegistryObject<Item> CHERRY_CHEESE_PIE_SLICE = ITEMS.register("cherry_cheese_pie_slice",
            () -> new TATDConsumableItem(foodItem(TATDFoodValues.CHEESE_PIE_SLICE),
                    true));

    public static final RegistryObject<Item> CHERRY_CAKE_SLICE = ITEMS.register("cherry_cake_slice",
            () -> new TATDConsumableItem(foodItem(TATDFoodValues.CHERRY_CAKE_SLICE),
                    true));

    public static final RegistryObject<Item> CHEESE_SLICE = ITEMS.register("cheese_slice",
            () -> new TATDConsumableItem(foodItem(TATDFoodValues.CHEESE_SLICE),
                    false));
    public static final RegistryObject<Item> CHERRY_CHEESE_SLICE = ITEMS.register("cherry_cheese_slice",
            () -> new TATDConsumableItem(foodItem(TATDFoodValues.CHERRY_CHEESE_SLICE),
                    true));

    //Crop
    public static final RegistryObject<Item> LANTERN_FRUIT_SEEDS = ITEMS.register("lantern_fruit_seeds",
            () -> new ItemNameBlockItem(ModBlock.BUDDING_LANTERN_FRUIT_CROP.get(), basicItem()));

    //Tool
    public static final RegistryObject<Item> POTTERY_COOKING_POT = ITEMS.register("pottery_cooking_pot",
            () -> new CookingPotItem(ModBlock.POTTERY_COOKING_POT.get(), basicItem()
                    .stacksTo(1)));

    public static final RegistryObject<BlockItem> MUD_STOVE = ITEMS.register("mud_stove",
            () -> new BlockItem(ModBlock.MUD_STOVE.get(), new Item.Properties()
                    ));

    //Crate
    public static final RegistryObject<Item> LANTERN_FRUIT_CRATE = ITEMS.register("lantern_fruit_crate",
            () -> new BlockItem(ModBlock.LANTERN_FRUIT_CRATE.get(), basicItem()));

    public static final RegistryObject<Item> PITCHER_TARO_CRATE = ITEMS.register("pitcher_taro_crate",
            () -> new BlockItem(ModBlock.PITCHER_TARO_CRATE.get(), basicItem()));

    //Knives
    public static final RegistryObject<Item> CHERRY_IRON_KNIFE = ITEMS.register("cherry_iron_knife", CherryIronKnife::new);

    public static final RegistryObject<Item> SNIFFER_EGGSHELL_KNIFE = ITEMS.register("sniffer_eggshell_knife", SnifferEggshellKnife::new);

    //Basic Block
    public static final RegistryObject<BlockItem> SNIFFER_EGGSHELL = ITEMS.register("sniffer_eggshell",
            () -> new BlockItem(ModBlock.SNIFFER_EGGSHELL.get(), basicItem()
            ));

    public static final RegistryObject<BlockItem> CURD_BLOCK = ITEMS.register("curd_block",
            () -> new BlockItem(ModBlock.CURD_BLOCK.get(), basicItem()
            ));

    //Basic Food
    public static final RegistryObject<Item> FRIED_SNIFFER_EGG = ITEMS.register("fried_sniffer_egg",
            () -> new TATDConsumableItem(foodItem(TATDFoodValues.FRIED_SNIFFER_EGG),
                    false));

    public static final RegistryObject<Item> BAKED_PITCHER_POD = ITEMS.register("baked_pitcher_pod",
            () -> new TATDConsumableItem(foodItem(TATDFoodValues.PITCHER_POD),
                    true));

    public static final RegistryObject<Item> BAKED_TORCHFLOWER_SEEDS = ITEMS.register("baked_torchflower_seeds",
            () -> new TATDConsumableItem(foodItem(TATDFoodValues.TORCHFLOWER_SEEDS),
                    true));

    public static final RegistryObject<Item> TARO = ITEMS.register("pitcher_taro",
            () -> new TATDConsumableItem(foodItem(TATDFoodValues.TARO),
                    true));

    public static final RegistryObject<Item> COOKED_TARO = ITEMS.register("cooked_pitcher_taro",
            () -> new TATDConsumableItem(foodItem(TATDFoodValues.COOKED_TARO),
                    true));


    //Drink
    public static final RegistryObject<Item> ANCIENT_COFFEE = ITEMS.register("ancient_coffee",
            () -> new DrinkableItem(drinkItem(TATDFoodValues.ANCIENT_COFFEE).rarity(Rarity.UNCOMMON).rarity(TrailAndTalesDelightMod.ANCIENT),
                    true, false));
    public static final RegistryObject<Item> PITCHER_PLANT_TEA = ITEMS.register("pitcher_plant_tea",
            () -> new DrinkableItem(drinkItem(TATDFoodValues.PITCHER_PLANT_TEA),
                    true, false));
    public static final RegistryObject<Item> TORCHFLOWER_TEA = ITEMS.register("torchflower_tea",
            () -> new DrinkableItem(drinkItem(TATDFoodValues.TORCHFLOWER_TEA),
                    true, false));
    public static final RegistryObject<Item> CHERRY_PETAL_TEA = ITEMS.register("cherry_petal_tea",
            () -> new DrinkableItem(drinkItem(TATDFoodValues.CHERRY_PETAL_TEA),
                    true, false));
    //Fruit
    public static final RegistryObject<Item> LANTERN_FRUIT = ITEMS.register("lantern_fruit",
            () -> new TATDConsumableItem(foodItem(TATDFoodValues.LANTERN_FRUIT),
                    true));

    public static final RegistryObject<Item> GOLDEN_LANTERN_FRUIT = ITEMS.register("golden_lantern_fruit",
            () -> new TATDConsumableItem(foodItem(TATDFoodValues.GOLDEN_LANTERN_FRUIT).rarity(Rarity.RARE),
                    true));

    //Basic Item
    public static final RegistryObject<Item> POTTERY_BOWL = ITEMS.register("pottery_bowl",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHERRY_PETAL = ITEMS.register("cherry_petal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_CHERRY_PETAL = ITEMS.register("dried_cherry_petal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PITCHER_PLANT = ITEMS.register("pitcher_plant",
            () -> new PitcherPlant(new Item.Properties()));

    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return new Item.Properties()
                .food(food)
                .craftRemainder(Items.BOWL)
                .stacksTo(16);
    }
    public static Item.Properties drinkItem(FoodProperties food) {
        return new Item.Properties()
                .food(food)
                .craftRemainder(Items.GLASS_BOTTLE)
                .stacksTo(16);
    }
    public static Item.Properties stickFoodItem(FoodProperties food) {
        return new Item.Properties()
                .food(food)
                .craftRemainder(Items.STICK)
                .stacksTo(16);
    }
    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties()
                .food(food);
    }
}
