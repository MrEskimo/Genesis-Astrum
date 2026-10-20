package net.mreskimo.gam.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.mreskimo.gam.GAM;
import net.mreskimo.gam.blocks.GAMBlocks;

public class GAMBlockStateProvider extends BlockStateProvider {
    public GAMBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GAM.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(GAMBlocks.CERES_LIGHT_SAND);
        blockWithItem(GAMBlocks.CERES_SAND);
        blockWithItem(GAMBlocks.CERES_ROCKY_SAND);
        blockWithItem(GAMBlocks.CERES_STONE);
        blockWithItem(GAMBlocks.CERES_LIGHT_ROCKY_SAND);
        blockWithItem(GAMBlocks.CERES_SALT_DEPOSIT);
        //blockWithItem(GAMBlocks.ICY_DUST);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
