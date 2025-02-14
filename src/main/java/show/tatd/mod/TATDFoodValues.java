package show.tatd.mod;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
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
    public static final FoodComponent FRIED_SNIFFER_EGG = new FoodComponent.Builder()
            .hunger(6).saturationModifier(0.6f)
            .build();
    public static final FoodComponent CHEESE_PIE_SLICE = new FoodComponent.Builder()
            .hunger(3).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, FIFE_SECONDS, 0), 1.0F)
            .build();
    public static final FoodComponent CHERRY_CAKE_SLICE = new FoodComponent.Builder()
            .hunger(4).saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, FIFE_SECONDS, 0), 1.0F)
            .build();
    public static final FoodComponent STUFFED_SNIFFER_EGG = (new FoodComponent.Builder())
            .hunger(16).saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F).build();
    public static final FoodComponent CHEESE_SLICE = new FoodComponent.Builder()
            .hunger(5).saturationModifier(0.5f)
            .build();
    public static final FoodComponent CHERRY_CHEESE_SLICE = new FoodComponent.Builder()
            .hunger(6).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, FIFE_SECONDS, 0), 1.0F)
            .build();
    public static final FoodComponent PITCHER_POD = new FoodComponent.Builder()
            .hunger(1).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, TEN_SECONDS, 0), 1.0F)
            .alwaysEdible()
            .build();
    public static final FoodComponent TORCHFLOWER_SEEDS = new FoodComponent.Builder()
            .hunger(1).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, TEN_SECONDS, 0), 1.0F)
            .alwaysEdible()
            .build();
    public static final FoodComponent ANCIENT_COFFEE = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, MEDIUM_DURATION, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, MEDIUM_DURATION, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F)
            .alwaysEdible()
            .build();
    public static final FoodComponent TORCHFLOWER_TEA = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, SHORT_DURATION, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F)
            .alwaysEdible()
            .build();
    public static final FoodComponent PITCHER_PLANT_TEA = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, SHORT_DURATION, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F)
            .alwaysEdible()
            .build();
    public static final FoodComponent CHERRY_PETAL_TEA = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, BRIEF_DURATION, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F)
            .alwaysEdible()
            .build();
    public static final FoodComponent TARO = new FoodComponent.Builder()
            .hunger(3).saturationModifier(0.75f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, TEN_SECONDS, 1), 1.0F)
            .alwaysEdible()
            .build();
    public static final FoodComponent COOKED_TARO = new FoodComponent.Builder()
            .hunger(7).saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, SHORT_DURATION, 1), 1.0F)
            .alwaysEdible()
            .build();
    public static final FoodComponent LANTERN_FRUIT = new FoodComponent.Builder()
            .hunger(2).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, SHORT_DURATION, 0), 1.0F)
            .alwaysEdible()
            .build();
    public static final FoodComponent GOLDEN_LANTERN_FRUIT = new FoodComponent.Builder()
            .hunger(4).saturationModifier(1.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, MEDIUM_DURATION, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, MEDIUM_DURATION, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, FIFE_SECONDS, 2), 1.0F)
            .alwaysEdible()
            .build();
}
