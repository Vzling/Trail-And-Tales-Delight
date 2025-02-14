package show.tatd.mod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import show.tatd.mod.TrailAndTalesDelightMod;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class SnifferEggshellKnife extends KnifeItem {
    public SnifferEggshellKnife() {
        super(new ToolMaterial() {
            public int getDurability() {
                return 197;
            }

            public float getMiningSpeedMultiplier() {
                return 9f;
            }

            public float getAttackDamage() {
                return 4.5f;
            }

            public int getMiningLevel() {
                return 2;
            }

            public int getEnchantability() {
                return 26;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.ofStacks();
            }
        }, 1, -2f, new Item.Settings()/*.rarity(TrailAndTalesDelightMod.ANCIENT)*/);
    }
}
