package show.tatd.mod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import show.tatd.mod.TrailAndTalesDelightMod;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class SnifferEggshellKnife extends KnifeItem {
    public SnifferEggshellKnife() {
        super(new Tier() {
            public int getUses() {
                return 197;
            }

            public float getSpeed() {
                return 9f;
            }

            public float getAttackDamageBonus() {
                return 4.5f;
            }

            public int getLevel() {
                return 2;
            }

            public int getEnchantmentValue() {
                return 26;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of();
            }
        }, 1, -2f, new Properties().rarity(TrailAndTalesDelightMod.ANCIENT));
    }
}
