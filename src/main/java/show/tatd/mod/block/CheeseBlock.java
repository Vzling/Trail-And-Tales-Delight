package show.tatd.mod.block;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.ItemUtils;

import java.util.Iterator;
import java.util.function.Supplier;

public class CheeseBlock extends PieBlock {
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);

    public CheeseBlock(Properties properties, Supplier<Item> pieSlice) {
        super(properties, pieSlice);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(hand);
        if (level.isClientSide) {
            if (heldStack.is(ModTags.KNIVES)) {
                return this.cutSlice(level, pos, state, player);

            }

            if (this.consumeBite(level, pos, state, player) == InteractionResult.SUCCESS) {
                return InteractionResult.SUCCESS;
            }

            if (heldStack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return heldStack.is(ModTags.KNIVES) ? this.cutSlice(level, pos, state, player) : this.consumeBite(level, pos, state, player);
    }

    protected InteractionResult consumeBite(Level level, BlockPos pos, BlockState state, Player playerIn) {
        if (!playerIn.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            ItemStack sliceStack = this.getPieSliceItem();
            FoodProperties sliceFood = sliceStack.getItem().getFoodProperties();
            playerIn.getFoodData().eat(sliceStack.getItem(), sliceStack);
            if (this.getPieSliceItem().getItem().isEdible() && sliceFood != null) {
                Iterator var7 = sliceFood.getEffects().iterator();

                while(var7.hasNext()) {
                    Pair<MobEffectInstance, Float> pair = (Pair)var7.next();
                    if (!level.isClientSide && pair.getFirst() != null && level.random.nextFloat() < (Float)pair.getSecond()) {
                        playerIn.addEffect(new MobEffectInstance((MobEffectInstance)pair.getFirst()));
                    }
                }
            }

            int bites = (Integer)state.getValue(BITES);
            if (bites < this.getMaxBites() - 1) {
                level.setBlock(pos, (BlockState)state.setValue(BITES, bites + 1), 3);
            } else {
                level.removeBlock(pos, false);
            }

            level.playSound((Player)null, pos, SoundEvents.HONEY_BLOCK_STEP, SoundSource.PLAYERS, 0.8F, 0.8F);
            return InteractionResult.SUCCESS;
        }
    }

    protected InteractionResult cutSlice(Level level, BlockPos pos, BlockState state, Player player) {
        int bites = (Integer)state.getValue(BITES);
        if (bites < this.getMaxBites() - 1) {
            level.setBlock(pos, (BlockState)state.setValue(BITES, bites + 1), 3);
        } else {
            level.removeBlock(pos, false);
        }

        Direction direction = player.getDirection().getOpposite();
        ItemUtils.spawnItemEntity(level, this.getPieSliceItem(), (double)pos.getX() + 0.5, (double)pos.getY() + 0.3, (double)pos.getZ() + 0.5, (double)direction.getStepX() * 0.15, 0.05, (double)direction.getStepZ() * 0.15);
        level.playSound((Player)null, pos, SoundEvents.HONEY_BLOCK_STEP, SoundSource.PLAYERS, 0.8F, 0.8F);
        return InteractionResult.SUCCESS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
