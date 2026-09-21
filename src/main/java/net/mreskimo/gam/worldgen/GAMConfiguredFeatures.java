package net.mreskimo.gam.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.mreskimo.gam.GAM;
import net.mreskimo.gam.blocks.GAMBlocks;
import net.mreskimo.gam.util.GAMTags;

import java.util.List;

public class GAMConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ICY_DUST_DISK = registerKey("icy_dust_disk");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest ceresReplaceable = new TagMatchTest(GAMTags.Blocks.CERES_REPLACEABLE);

        register(context, ICY_DUST_DISK, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(GAMBlocks.ICY_DUST.get()), BlockPredicate.matchesBlocks(List.of(GAMBlocks.CERES_SAND.get(), GAMBlocks.CERES_SALT_DEPOSIT.get())), UniformInt.of(2, 3), 1));

    }
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(GAM.MOD_ID, name));
    }
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
