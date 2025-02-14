package show.tatd.mod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class CherryIronKnife extends KnifeItem {
    public CherryIronKnife() {
        super(new Tier() {
            public int getUses() {
                return 742;
            }

            public float getSpeed() {
                return 9f;
            }

            public float getAttackDamageBonus() {
                return 2.5f;
            }

            public int getLevel() {
                return 2;
            }

            public int getEnchantmentValue() {
                return 21;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of();
            }
        }, 1, -2f, new Properties().rarity(Rarity.EPIC));
    }
}
