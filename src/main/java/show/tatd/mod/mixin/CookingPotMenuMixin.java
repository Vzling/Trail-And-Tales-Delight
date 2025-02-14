package show.tatd.mod.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import show.tatd.mod.init.ModBlock;
import vectorwing.farmersdelight.common.block.entity.container.CookingPotMenu;

@Mixin(CookingPotMenu.class)
public abstract class CookingPotMenuMixin extends AbstractRecipeScreenHandler<Inventory> {

    @Shadow(remap = false)
    @Final
    private ScreenHandlerContext canInteractWithCallable;

    @Shadow public abstract boolean canUse(PlayerEntity playerIn);

    public CookingPotMenuMixin(ScreenHandlerType<?> pMenuType, int pContainerId) {
        super(pMenuType, pContainerId);
    }

    @Inject(at = @At("HEAD"), method = "canUse", cancellable = true)
    public void addBlock(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        if (canUse(canInteractWithCallable, player, ModBlock.POTTERY_COOKING_POT)) {
            cir.setReturnValue(true);
        }
    }
}
