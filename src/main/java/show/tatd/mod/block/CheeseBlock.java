package show.tatd.mod.block;

import com.mojang.datafixers.util.Pair;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.ItemUtils;

import java.util.Iterator;
import java.util.function.Supplier;

public class CheeseBlock extends PieBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);

    public CheeseBlock(AbstractBlock.Settings properties, Supplier<Item> pieSlice) {
        super(properties, pieSlice);
    }

    public ItemActionResult onUseWithItem(ItemStack heldStack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return heldStack.isIn(ModTags.KNIVES) ? this.cutSlice(level, pos, state, player) : ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, BlockHitResult hitResult) {
        if (level.isClient) {
            if (this.consumeBite(level, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }

            if (player.getStackInHand(Hand.MAIN_HAND).isEmpty()) {
                return ActionResult.CONSUME;
            }
        }

        return this.consumeBite(level, pos, state, player);
    }

    protected ActionResult consumeBite(World level, net.minecraft.util.math.BlockPos pos, BlockState state, PlayerEntity playerIn) {
        if (!playerIn.canConsume(false)) {
            return ActionResult.PASS;
        } else {
            ItemStack sliceStack = this.getPieSliceItem();
            FoodComponent sliceFood = sliceStack.getComponents().get(DataComponentTypes.FOOD);
            playerIn.getHungerManager().eat(sliceFood);
            if (sliceFood != null) {
                Iterator var7 = sliceFood.effects().iterator();

                while (var7.hasNext()) {
                    Pair<StatusEffectInstance, Float> pair = (Pair) var7.next();
                    if (!level.isClient && pair.getFirst() != null && level.random.nextFloat() < (Float) pair.getSecond()) {
                        playerIn.addStatusEffect(new StatusEffectInstance((StatusEffectInstance) pair.getFirst()));
                    }
                }
            }

            int bites = (Integer) state.get(BITES);
            if (bites < this.getMaxBites() - 1) {
                level.setBlockState(pos, (BlockState) state.with(BITES, bites + 1), 3);
            } else {
                level.removeBlock(pos, false);
            }

            level.playSound((PlayerEntity) null, pos, SoundEvents.BLOCK_HONEY_BLOCK_STEP, SoundCategory.PLAYERS, 0.8F, 0.8F);
            return ActionResult.SUCCESS;
        }
    }

    protected ItemActionResult cutSlice(World level, net.minecraft.util.math.BlockPos pos, BlockState state, PlayerEntity player) {
        int bites = (Integer) state.get(BITES);
        if (bites < this.getMaxBites() - 1) {
            level.setBlockState(pos, (BlockState) state.with(BITES, bites + 1), 3);
        } else {
            level.removeBlock(pos, false);
        }

        Direction direction = player.getHorizontalFacing().getOpposite();
        ItemUtils.spawnItemEntity(level, this.getPieSliceItem(), (double) pos.getX() + 0.5, (double) pos.getY() + 0.3, (double) pos.getZ() + 0.5, (double) direction.getOffsetX() * 0.15, 0.05, (double) direction.getOffsetZ() * 0.15);
        level.playSound((PlayerEntity) null, pos, SoundEvents.BLOCK_HONEY_BLOCK_STEP, SoundCategory.PLAYERS, 0.8F, 0.8F);
        return ItemActionResult.SUCCESS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
