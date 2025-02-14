package show.tatd.mod.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PitcherPlant extends Item {
    public PitcherPlant(Item.Settings properties) {
        super(properties);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World level, List<Text> list, TooltipContext flag) {
        super.appendTooltip(stack, level, list, flag);
        list.add(Text.translatable(getTranslationKey() + ".tooltip").formatted(Formatting.GRAY));
    }
}
