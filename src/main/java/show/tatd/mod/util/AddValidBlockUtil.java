package show.tatd.mod.util;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;

import java.util.HashSet;
import java.util.Set;

public class AddValidBlockUtil {
    public static void addBlock(BlockEntityType<?> type, Block block) {
        Set<Block> set = new HashSet<>(type.blocks);
        set.add(block);
        type.blocks = set;
    }
}
