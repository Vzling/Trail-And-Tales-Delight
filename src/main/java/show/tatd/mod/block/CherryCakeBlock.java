package show.tatd.mod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.function.Supplier;

public class CherryCakeBlock extends PieBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);

    public CherryCakeBlock(AbstractBlock.Settings properties, Supplier<Item> pieSlice) {
        super(properties, pieSlice);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView level, net.minecraft.util.math.BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
