package show.tatd.mod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Rarity;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class CherryIronKnife extends KnifeItem {
    public CherryIronKnife() {
        super(new ToolMaterial() {
            public int getDurability() {
                return 742;
            }

            public float getMiningSpeedMultiplier() {
                return 9f;
            }

            public float getAttackDamage() {
                return 2.5f;
            }

            public int getMiningLevel() {
                return 2;
            }

            public int getEnchantability() {
                return 21;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.ofItems();
            }
        }, 1, -2f, new Item.Settings().rarity(Rarity.EPIC));
    }
}
