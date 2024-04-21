package mods.officialy.fluidity.mixin;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.WaterFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WaterFluid.class)
public class WaterFluidMixin {
/*
    @Inject(method = "canConvertToSource(Lnet/minecraft/world/level/Level;)Z", at = @At("HEAD"), cancellable = true)
    protected void canConvertToSource(Level p_256670_, CallbackInfoReturnable<Boolean> p_256671_) {
        p_256671_.setReturnValue(false);
    }

    @Inject(method = "getTickDelay(Lnet/minecraft/world/level/LevelReader;)I", at = @At("HEAD"), cancellable = true)
    public void getTickDelay(LevelReader p_76454_, CallbackInfoReturnable<Integer> p_256671_) {
        p_256671_.setReturnValue(3);
    }

    @Inject(method = "getSource()Lnet/minecraft/world/level/material/Fluid;", at = @At("HEAD"), cancellable = true)
    public void getSource(CallbackInfoReturnable<Fluid> info) {
        info.setReturnValue(Fluids.FLOWING_WATER);
    }*/
}