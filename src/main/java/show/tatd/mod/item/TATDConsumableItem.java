package show.tatd.mod.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.List;

public class TATDConsumableItem extends Item {
    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;

    public TATDConsumableItem(Item.Settings properties) {
        super(properties);
        this.hasFoodEffectTooltip = false;
        this.hasCustomTooltip = false;
    }

    public TATDConsumableItem(Item.Settings properties, boolean hasFoodEffectTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = false;
    }

    public TATDConsumableItem(Item.Settings properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = hasCustomTooltip;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World level, LivingEntity consumer) {
        if (!level.isClient) {
            this.affectConsumer(stack, level, consumer);
        }

        ItemStack containerStack = stack.getItem().getRecipeRemainder(stack);

        if (stack.getComponents().get(DataComponentTypes.FOOD) != null) {
            super.finishUsing(stack, level, consumer);
        } else {
            PlayerEntity player = consumer instanceof PlayerEntity ? (PlayerEntity) consumer : null;
            if (player instanceof ServerPlayerEntity) {
                Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity) player, stack);
            }
            if (player != null) {
                player.incrementStat(Stats.USED.getOrCreateStat(this));
                if (!player.getAbilities().creativeMode) {
                    stack.increment(1);
                }
            }
        }

        if (stack.isEmpty()) {
            return containerStack;
        } else {
            if (consumer instanceof PlayerEntity player && !((PlayerEntity) consumer).getAbilities().creativeMode) {
                if (!player.getInventory().insertStack(containerStack)) {
                    player.dropItem(containerStack, false);
                }
            }
            return stack;
        }
    }

    /**
     * Override this to apply changes to the consumer (e.g. curing effects).
     */
    public void affectConsumer(ItemStack stack, World level, LivingEntity consumer) {
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            if (this.hasCustomTooltip) {
                MutableText textEmpty = TextUtils.getTranslation("tooltip." + this);
                tooltip.add(textEmpty.formatted(Formatting.BLUE));
            }
            if (this.hasFoodEffectTooltip) {
                TextUtils.addFoodEffectTooltip(stack, Text::getContent, 1.0F, context.getUpdateTickRate());
            }
        }
    }
}
