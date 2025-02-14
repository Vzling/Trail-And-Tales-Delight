package show.tatd.mod.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.RecipeBookMenu;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import show.tatd.mod.init.ModBlock;
import vectorwing.farmersdelight.common.block.entity.container.CookingPotMenu;

@Mixin(CookingPotMenu.class)
public abstract class CookingPotMenuMixin extends RecipeBookMenu<RecipeInput, Recipe<RecipeInput>> {

    @Shadow(remap = false)
    @Final
    private ContainerLevelAccess canInteractWithCallable;

    public CookingPotMenuMixin(MenuType<?> pMenuType, int pContainerId) {
        super(pMenuType, pContainerId);
    }

    @Inject(at = @At("HEAD"), method = "stillValid", cancellable = true, remap = false)
    public void addBlock(Player player, CallbackInfoReturnable<Boolean> cir) {
        if (stillValid(canInteractWithCallable, player, ModBlock.POTTERY_COOKING_POT.get())) {
            cir.setReturnValue(true);
        }
    }
}
