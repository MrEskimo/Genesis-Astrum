package net.mreskimo.gam.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mreskimo.gam.GAM;
import net.mreskimo.gam.blocks.GAMBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class GAMBlockTagGenerator extends BlockTagsProvider {
    public GAMBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GAM.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(GAMBlocks.CERES_LIGHT_SAND.get(),
                    GAMBlocks.CERES_SAND.get(),
                    GAMBlocks.CERES_ROCKY_SAND.get(),
                    GAMBlocks.DEIMOS_STONE.get(),
                    GAMBlocks.PHOBOS_STONE.get(),
                    GAMBlocks.CERES_STONE.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(GAMBlocks.CERES_LIGHT_SAND.get(),
                    GAMBlocks.CERES_SAND.get(),
                    GAMBlocks.CERES_ROCKY_SAND.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(GAMBlocks.CERES_STONE.get(),
                        GAMBlocks.PHOBOS_STONE.get(),
                        GAMBlocks.DEIMOS_STONE.get());

        this.tag(BlockTags.OVERWORLD_CARVER_REPLACEABLES)
                .add(GAMBlocks.CERES_STONE.get(),
                        GAMBlocks.CERES_SAND.get(),
                        GAMBlocks.CERES_ROCKY_SAND.get(),
                        GAMBlocks.CERES_LIGHT_ROCKY_SAND.get(),
                        GAMBlocks.CERES_LIGHT_SAND.get(),
                        GAMBlocks.CERES_SALT_DEPOSIT.get());

    }
}
