package net.mreskimo.gam.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.mreskimo.gam.GAM;

public class GAMBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_ICY_DUST_DISK = registerKey("add_icy_dust_disk");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

  /*      context.register(ADD_ICY_DUST_DISK, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(),
                HolderSet.direct(placedFeatures.getOrThrow(GAMPlacedFeatures.ICY_DUST_DISK_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
*/
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(GAM.MOD_ID, name));
    }
}
