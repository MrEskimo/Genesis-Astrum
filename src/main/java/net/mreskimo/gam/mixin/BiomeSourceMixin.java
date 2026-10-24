package net.mreskimo.gam.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(BiomeSource.class)
public class BiomeSourceMixin {
    @Inject(method = "bootstrap", at = @At())

}
