package net.mreskimo.gam.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.mreskimo.gam.GAM;
import net.mreskimo.gam.worldgen.GAMBiomeModifiers;
import net.mreskimo.gam.worldgen.GAMConfiguredFeatures;
import net.mreskimo.gam.worldgen.GAMPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class GAMWorldgenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, GAMConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, GAMPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, GAMBiomeModifiers::bootstrap);
            //.add(Registries.BIOME, ModBiomes::boostrap);

    public GAMWorldgenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(GAM.MOD_ID));
    }
}