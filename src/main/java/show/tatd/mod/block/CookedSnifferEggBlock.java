package show.tatd.mod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import show.tatd.mod.init.ModBlock;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.function.Supplier;

public class CookedSnifferEggBlock extends FeastBlock {
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 2.0D, 15.0D, 12.0D, 14.0D);

    public CookedSnifferEggBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties.noOcclusion().isRedstoneConductor((bs, br, bp) -> false), servingItem, hasLeftovers);
    }
    protected InteractionResult takeServing(LevelAccessor levelacc, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(getServingsProperty());
        ItemStack serving = this.getServingItem(state);
        ItemStack heldStack = player.getItemInHand(hand);

        if (servings > 3) {
            if (!serving.hasCraftingRemainingItem() || ItemStack.isSameItem(heldStack, serving.getCraftingRemainingItem())) {
                levelacc.setBlock(pos, state.setValue(getServingsProperty(), servings - 1), 3);
                if (!player.getAbilities().instabuild && serving.hasCraftingRemainingItem()) {
                    heldStack.shrink(1);
                }
                if (!player.getInventory().add(serving)) {
                    player.drop(serving, false);
                }
                if (levelacc.getBlockState(pos).getValue(getServingsProperty()) == 0 && !this.hasLeftovers) {
                    levelacc.removeBlock(pos, false);
                }
                levelacc.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
                levelacc.setBlock(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ()), ModBlock.SNIFFER_EGGSHELL.get().defaultBlockState(), 3);
                return InteractionResult.SUCCESS;
            } else {
                player.displayClientMessage(TextUtils.getTranslation("block.feast.use_container", serving.getCraftingRemainingItem().getHoverName()), true);
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}