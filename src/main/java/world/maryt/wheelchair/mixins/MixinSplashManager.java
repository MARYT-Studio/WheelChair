package world.maryt.wheelchair.mixins;

import net.minecraft.client.gui.components.SplashRenderer;
import net.minecraft.client.resources.SplashManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = SplashManager.class)
public class MixinSplashManager {
    @Inject(
            method = "getSplash",
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true)
    public void inject_getSplash(CallbackInfoReturnable<SplashRenderer> cir) {
        cir.setReturnValue(new SplashRenderer("§e§lYou Are The §c§lOnly §e§lChamp"));
    }
}
