package show.tatd.mod;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class TATDFoodValues {
    public static final int FIFE_SECONDS = 100;    // 5 seconds
    public static final int TEN_SECONDS = 200;    // 10 seconds
    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes
    public static final int SUPER_LONG_DURATION = 24000;    // 20 minutes

    // Feast Portions
    public static final FoodProperties FRIED_SNIFFER_EGG = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.6f)
            .build();
    public static final FoodProperties CHEESE_PIE_SLICE = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, FIFE_SECONDS, 0), 1.0F)
            .build();
    public static final FoodProperties CHERRY_CAKE_SLICE = new FoodProperties.Builder()
            .nutrition(4).saturationMod(1f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, FIFE_SECONDS, 0), 1.0F)
            .build();
    public static final FoodProperties STUFFED_SNIFFER_EGG = (new FoodProperties.Builder())
            .nutrition(16).saturationMod(1f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties CHEESE_SLICE = new FoodProperties.Builder()
            .nutrition(5).saturationMod(0.5f)
            .build();
    public static final FoodProperties CHERRY_CHEESE_SLICE = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, FIFE_SECONDS, 0), 1.0F)
            .build();
    public static final FoodProperties PITCHER_POD = new FoodProperties.Builder()
            .nutrition(1).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, TEN_SECONDS, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties TORCHFLOWER_SEEDS = new FoodProperties.Builder()
            .nutrition(1).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, TEN_SECONDS, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties ANCIENT_COFFEE = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, MEDIUM_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, MEDIUM_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties TORCHFLOWER_TEA = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, SHORT_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties PITCHER_PLANT_TEA = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, SHORT_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties CHERRY_PETAL_TEA = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, BRIEF_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties TARO = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.75f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, TEN_SECONDS, 1), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties COOKED_TARO = new FoodProperties.Builder()
            .nutrition(7).saturationMod(1f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, SHORT_DURATION, 1), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties LANTERN_FRUIT = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, SHORT_DURATION, 0), 1.0F)
            .alwaysEat()
            .build();
    public static final FoodProperties GOLDEN_LANTERN_FRUIT = new FoodProperties.Builder()
            .nutrition(4).saturationMod(1.5f)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, MEDIUM_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, MEDIUM_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, FIFE_SECONDS, 2), 1.0F)
            .alwaysEat()
            .build();
}
