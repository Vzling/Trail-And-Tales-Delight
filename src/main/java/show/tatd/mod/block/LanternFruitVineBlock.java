package show.tatd.mod.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;
import show.tatd.mod.init.ModBlock;
import show.tatd.mod.init.ModItem;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.block.TomatoVineBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModSounds;
import vectorwing.farmersdelight.common.tag.ModTags;

@SuppressWarnings("deprecation")
public class LanternFruitVineBlock extends CropBlock {
    public static final IntProperty VINE_AGE = Properties.AGE_3;
    public static final BooleanProperty ROPELOGGED = BooleanProperty.of("ropelogged");
    private static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

    public LanternFruitVineBlock(AbstractBlock.Settings properties) {
        super(properties);
        setDefaultState(stateManager.getDefaultState().with(getAgeProperty(), 0).with(ROPELOGGED, false));
    }

    public static void destroyAndPlaceRope(World level, net.minecraft.util.math.BlockPos pos) {
        Block configuredRopeBlock = Registries.BLOCK.get(Identifier.tryParse(Configuration.DEFAULT_TOMATO_VINE_ROPE.get()));
        Block finalRopeBlock = configuredRopeBlock != null ? configuredRopeBlock : ModBlocks.ROPE.get();

        level.setBlockState(pos, finalRopeBlock.getDefaultState());
    }

    @Override
    protected ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        int age = state.get(getAgeProperty());
        boolean isMature = age == getMaxAge();
        if (!isMature && player.getStackInHand(Hand.MAIN_HAND).getItem().equals(Items.BONE_MEAL)) {
            return ActionResult.PASS;
        } else if (isMature) {
            int quantity = 1 + level.random.nextInt(2);
            dropStack(level, pos, new ItemStack(ModItem.LANTERN_FRUIT, quantity));
            level.playSound(null, pos, ModSounds.ITEM_TOMATO_PICK_FROM_BUSH.get(), SoundCategory.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            if (level.random.nextFloat() < 0.05) {
                dropStack(level, pos, new ItemStack(ModItem.GOLDEN_LANTERN_FRUIT));
                level.playSound(null, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            }

            level.setBlockState(pos, state.with(getAgeProperty(), 0), 2);
            return ActionResult.SUCCESS;
        } else {
            return super.onUse(state, level, pos, player, hit);
        }
    }

    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        if (!level.isChunkLoaded(pos)) return;
        if (level.getBaseLightLevel(pos, 0) >= 9) {
            int age = this.getAge(state);
            if (age < this.getMaxAge()) {
                float speed = getAvailableMoisture(this, level, pos);
                if (random.nextInt((int) (25.0F / speed) + 1) == 0) {
                    level.setBlockState(pos, state.with(getAgeProperty(), age + 1), 2);
                }
            }
            attemptRopeClimb(level, pos, random);
        }
    }

    public void attemptRopeClimb(ServerWorld level, BlockPos pos, Random random) {
        if (random.nextFloat() < 0.3F) {
            BlockPos posAbove = pos.up();
            BlockState stateAbove = level.getBlockState(posAbove);
            boolean canClimb = Configuration.ENABLE_TOMATO_VINE_CLIMBING_TAGGED_ROPES.get() ? stateAbove.isIn(ModTags.ROPES) : stateAbove.equals(ModBlocks.ROPE);
            if (canClimb) {
                int vineHeight;
                for (vineHeight = 1; level.getBlockState(pos.down(vineHeight)).getBlock().equals(this); ++vineHeight) {
                }
                if (vineHeight < 3) {
                    level.setBlockState(posAbove, getDefaultState().with(ROPELOGGED, true));
                }
            }
        }

    }

    @Override
    public BlockState withAge(int age) {
        return this.getDefaultState().with(this.getAgeProperty(), age);
    }

    @Override
    public IntProperty getAgeProperty() {
        return VINE_AGE;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItem.LANTERN_FRUIT_SEEDS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(VINE_AGE, ROPELOGGED);
    }

    @Override
    protected int getGrowthAmount(World level) {
        return super.getGrowthAmount(level) / 2;
    }

    @Override
    public void grow(ServerWorld level, Random random, BlockPos pos, BlockState state) {
        int newAge = this.getAge(state) + this.getGrowthAmount(level);
        int maxAge = this.getMaxAge();
        if (newAge > maxAge) {
            newAge = maxAge;
        }

        level.setBlockState(pos, state.with(getAgeProperty(), newAge));
        attemptRopeClimb(level, pos, random);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return super.isFertilizable(world, pos, state);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        BlockPos belowPos = pos.down();
        BlockState belowState = level.getBlockState(belowPos);

        if (state.get(ROPELOGGED)) {
            return belowState.getBlock().equals(ModBlock.LANTERN_FRUIT_CROP) && hasGoodCropConditions(level, pos);
        }

        return super.canPlaceAt(state, level, pos);
    }

    public boolean hasGoodCropConditions(WorldView level, BlockPos pos) {
        return level.getBaseLightLevel(pos, 0) >= 8 || level.isSkyVisible(pos);
    }

    @Override
    public void afterBreak(World level, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        boolean isRopelogged = state.get(ROPELOGGED);
        super.afterBreak(level, player, pos, state, blockEntity, stack);

        if (isRopelogged) {
            destroyAndPlaceRope(level, pos);
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState facingState, WorldAccess level, BlockPos currentPos, BlockPos facingPos) {
        if (!state.canPlaceAt(level, currentPos)) {
            level.scheduleBlockTick(currentPos, this, 1);
        }

        return state;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        if (!state.canPlaceAt(level, pos)) {
            level.breakBlock(pos, true);
            if (state.get(ROPELOGGED)) {
                destroyAndPlaceRope(level, pos);
            }
        }
    }
}
