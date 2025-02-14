package show.tatd.mod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import show.tatd.mod.init.ModBlock;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.function.Supplier;

public class CookedSnifferEggBlock extends FeastBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 2.0D, 15.0D, 12.0D, 14.0D);

    public CookedSnifferEggBlock(AbstractBlock.Settings properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties.nonOpaque().solidBlock((bs, br, bp) -> false), servingItem, hasLeftovers);
    }

    protected ActionResult takeServing(WorldAccess levelacc, BlockPos pos, BlockState state, PlayerEntity player, Hand hand) {
        int servings = state.get(getServingsProperty());
        ItemStack serving = this.getServingItem(state);
        ItemStack heldStack = player.getStackInHand(hand);

        if (servings > 3) {
            if (!serving.getItem().hasRecipeRemainder() || ItemStack.areItemsEqual(heldStack, serving.getRecipeRemainder())) {
                levelacc.setBlockState(pos, state.with(getServingsProperty(), servings - 1), 3);
                if (!player.getAbilities().creativeMode && serving.getRecipeRemainder().isEmpty()) {
                    heldStack.decrement(1);
                }
                if (!player.getInventory().insertStack(serving)) {
                    player.dropItem(serving, false);
                }
                if (levelacc.getBlockState(pos).get(getServingsProperty()) == 0 && !this.hasLeftovers) {
                    levelacc.removeBlock(pos, false);
                }
                levelacc.playSound(null, pos, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.BLOCKS, 1.0F, 1.0F);
                levelacc.setBlockState(BlockPos.ofFloored(pos.getX(), pos.getY(), pos.getZ()), ModBlock.SNIFFER_EGGSHELL.getDefaultState(), 3);
                return ActionResult.SUCCESS;
            } else {
                player.sendMessage(TextUtils.getTranslation("block.feast.use_container", serving.getRecipeRemainder().getName()), true);
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}