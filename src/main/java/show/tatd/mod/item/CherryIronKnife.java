package show.tatd.mod.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
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

            @Override
            public TagKey<Block> getInverseTag() {
                return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
            }

            public int getLevel() {
                return 2;
            }

            public int getEnchantability() {
                return 21;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.ofItems();
            }
        }, new Item.Settings().rarity(Rarity.EPIC).attributeModifiers(createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2f)));
    }
}
