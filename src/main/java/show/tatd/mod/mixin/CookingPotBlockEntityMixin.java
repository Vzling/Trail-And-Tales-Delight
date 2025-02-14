package show.tatd.mod.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import show.tatd.mod.init.ModItem;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;

@Mixin(CookingPotBlockEntity.class)
public abstract class CookingPotBlockEntityMixin {
    @WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;m_150930_(Lnet/minecraft/world/item/Item;)Z"), method = "getMealFromItem", remap = false)
    private static boolean getMealFromItem(ItemStack stack, Item item, Operation<Boolean> old) {
        return stack.is(ModItem.POTTERY_COOKING_POT.get()) || old.call(stack, item);
    }

    @WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;m_150930_(Lnet/minecraft/world/item/Item;)Z"), method = "takeServingFromItem", remap = false)
    private static boolean takeServingFromItem(ItemStack stack, Item item, Operation<Boolean> old) {
        return stack.is(ModItem.POTTERY_COOKING_POT.get()) || old.call(stack, item);
    }

    @WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;m_150930_(Lnet/minecraft/world/item/Item;)Z"), method = "getContainerFromItem", remap = false)
    private static boolean getContainerFromItem(ItemStack stack, Item item, Operation<Boolean> old) {
        return stack.is(ModItem.POTTERY_COOKING_POT.get()) || old.call(stack, item);
    }
}
