package show.tatd.mod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
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

            @Override
            public TagKey<Block> getIncorrectBlocksForDrops() {
                return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
            }

            public int getEnchantmentValue() {
                return 21;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of();
            }
        },new Properties().rarity(Rarity.EPIC).attributes(createAttributes(Tiers.DIAMOND, 1, -2f)));
    }
}
