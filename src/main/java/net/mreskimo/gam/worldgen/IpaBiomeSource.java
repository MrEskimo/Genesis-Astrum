package net.mreskimo.gam.worldgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.QuartPos;
import net.minecraft.core.SectionPos;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.DensityFunction;

import java.util.stream.Stream;

public class IpaBiomeSource extends BiomeSource {
    public static final Codec<IpaBiomeSource> CODEC = RecordCodecBuilder.create((ipaBiomeSourceInstance) -> ipaBiomeSourceInstance.group(RegistryOps.retrieveElement(Biomes.PLAINS), RegistryOps.retrieveElement(Biomes.END_HIGHLANDS), RegistryOps.retrieveElement(Biomes.END_MIDLANDS), RegistryOps.retrieveElement(Biomes.SMALL_END_ISLANDS), RegistryOps.retrieveElement(Biomes.END_BARRENS)).apply(ipaBiomeSourceInstance, ipaBiomeSourceInstance.stable(IpaBiomeSource::new)));
    private final Holder<Biome> center;
    private final Holder<Biome> highlands;
    private final Holder<Biome> midlands;
    private final Holder<Biome> islands;
    private final Holder<Biome> barrens;

    public static IpaBiomeSource create(HolderGetter<Biome> biomeHolderGetter) {
        return new IpaBiomeSource(biomeHolderGetter.getOrThrow(Biomes.PLAINS), biomeHolderGetter.getOrThrow(Biomes.END_HIGHLANDS), biomeHolderGetter.getOrThrow(Biomes.END_MIDLANDS), biomeHolderGetter.getOrThrow(Biomes.SMALL_END_ISLANDS), biomeHolderGetter.getOrThrow(Biomes.END_BARRENS));
    }

    private IpaBiomeSource(Holder<Biome> biomeHolder, Holder<Biome> biomeHolder1, Holder<Biome> biomeHolder2, Holder<Biome> biomeHolder3, Holder<Biome> biomeHolder4) {
        this.center = biomeHolder;
        this.highlands = biomeHolder1;
        this.midlands = biomeHolder2;
        this.islands = biomeHolder3;
        this.barrens = biomeHolder4;
    }

    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        return Stream.of(this.center, this.highlands, this.midlands, this.islands, this.barrens);
    }

    protected Codec<? extends BiomeSource> codec() {
        return CODEC;
    }

    public Holder<Biome> getNoiseBiome(int p_204292_, int p_204293_, int p_204294_, Climate.Sampler sampler) {
        int i = QuartPos.toBlock(p_204292_);
        int j = QuartPos.toBlock(p_204293_);
        int k = QuartPos.toBlock(p_204294_);
        int l = SectionPos.blockToSectionCoord(i);
        int i1 = SectionPos.blockToSectionCoord(k);
        if ((long)l * (long)l + (long)i1 * (long)i1 <= 4096L) {
            return this.center;
        } else {
            int j1 = (SectionPos.blockToSectionCoord(i) * 2 + 1) * 8;
            int k1 = (SectionPos.blockToSectionCoord(k) * 2 + 1) * 8;
            double d0 = sampler.erosion().compute(new DensityFunction.SinglePointContext(j1, j, k1));
            if (d0 > (double)0.25F) {
                return this.highlands;
            } else if (d0 >= (double)-0.0625F) {
                return this.midlands;
            } else {
                return d0 < (double)-0.21875F ? this.islands : this.barrens;
            }
        }
    }
}