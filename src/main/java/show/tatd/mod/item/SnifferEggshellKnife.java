package show.tatd.mod.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
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

            @Override
            public TagKey<Block> getInverseTag() {
                return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
            }

            public int getLevel() {
                return 2;
            }

            public int getEnchantability() {
                return 26;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.ofStacks();
            }
        }, new Item.Settings()/*.rarity(TrailAndTalesDelightMod.ANCIENT)*/.attributeModifiers(createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2f)));
    }
}
