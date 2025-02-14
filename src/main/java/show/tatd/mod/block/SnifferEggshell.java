package show.tatd.mod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class SnifferEggshell extends Block {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 2.0D, 15.0D, 12.0D, 14.0D);

    public SnifferEggshell(AbstractBlock.Settings properties) {
        super(properties);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}