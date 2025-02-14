package show.tatd.mod.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import show.tatd.mod.init.ModItem;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;

@Mixin(CookingPotBlockEntity.class)
public abstract class CookingPotBlockEntityMixin {
    @WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"), method = "getMealFromItem")
    private static boolean getMealFromItem(ItemStack stack, Item item, Operation<Boolean> old) {
        return stack.isOf(ModItem.POTTERY_COOKING_POT) || old.call(stack, item);
    }

    @WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"), method = "takeServingFromItem")
    private static boolean takeServingFromItem(ItemStack stack, Item item, Operation<Boolean> old) {
        return stack.isOf(ModItem.POTTERY_COOKING_POT) || old.call(stack, item);
    }

    @WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"), method = "getContainerFromItem")
    private static boolean getContainerFromItem(ItemStack stack, Item item, Operation<Boolean> old) {
        return stack.isOf(ModItem.POTTERY_COOKING_POT) || old.call(stack, item);
    }
}
