package mods.officialy.fluidity.mixin;

import mods.officialy.fluidity.util.FluidMovementHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FlowingFluid.class)
public class FlowingFluidMixin {

/*    @Inject(method = "canSpreadTo(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/Direction;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/material/FluidState;Lnet/minecraft/world/level/material/Fluid;)Z", at = @At("HEAD"), cancellable = true)
    protected void canSpreadTo(BlockGetter p_75978_, BlockPos p_75979_, BlockState p_75980_, Direction p_75981_, BlockPos p_75982_, BlockState p_75983_, FluidState fluidState, Fluid p_75985_, CallbackInfoReturnable<Boolean> p_256671_) {
        if (fluidState.getType() instanceof WaterFluid)
            p_256671_.setReturnValue(true);
    }

    @Inject(method = "isSolidFace(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;)Z", at = @At("HEAD"), cancellable = true)
    protected void isSolidFace(BlockGetter p_75991_, BlockPos p_75992_, Direction p_75993_, CallbackInfoReturnable<Boolean> p_256671_) {
        if (p_75991_.getFluidState(p_75992_).getType() instanceof WaterFluid)
            p_256671_.setReturnValue(false);
    }

    @Inject(method = "spread(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/material/FluidState;)V", at = @At("HEAD"))
    protected void spread(Level level, BlockPos pos, FluidState fluidState, CallbackInfo p_256671_) {
        if (fluidState.getType() instanceof WaterFluid) {
//            FluidMovementHandler.initiateFluidMovement(level, pos);
        }
    }


    @Inject(method = "getNewLiquid(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Lnet/minecraft/world/level/material/FluidState;", at = @At("HEAD"), cancellable = true)
    protected void getNewLiquid(Level p_256464_, BlockPos p_76037_, BlockState p_76038_, CallbackInfoReturnable<FluidState> p_256671_) {
        if (p_256464_.getFluidState(p_76037_).getType() instanceof WaterFluid)
            p_256671_.setReturnValue(Fluids.WATER.getFlowing(p_76038_.getFluidState().getAmount(), false));
    }*/
}
