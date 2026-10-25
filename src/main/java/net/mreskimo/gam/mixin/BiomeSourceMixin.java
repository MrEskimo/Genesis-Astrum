package net.mreskimo.gam.mixin;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.BiomeSources;
import net.mreskimo.gam.worldgen.IpaBiomeSource;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BiomeSources.class, remap = false)
public class BiomeSourceMixin {
    @Inject(method = "bootstrap", at = @At(value = "TAIL"), cancellable = true)
    private static void ipaBiome(Registry<Codec<? extends BiomeSource>> codecRegistry, @NotNull CallbackInfoReturnable<Codec<? extends BiomeSource>> cir) {
        cir.setReturnValue(Registry.register(codecRegistry, "ipa_biome", IpaBiomeSource.CODEC));
    }
}