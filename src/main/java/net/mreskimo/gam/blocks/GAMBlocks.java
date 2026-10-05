package net.mreskimo.gam.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mreskimo.gam.GAM;
import net.mreskimo.gam.blocks.custom.BrownGasBlock;
import net.mreskimo.gam.item.GAMItems;

import java.util.function.Supplier;

public class GAMBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GAM.MOD_ID);

    public static final RegistryObject<Block> CERES_SAND = registerBlock("ceres_sand",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> CERES_STONE = registerBlock("ceres_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

    public static final RegistryObject<Block> CERES_SALT_DEPOSIT = registerBlock("ceres_salt_deposit",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

    public static final RegistryObject<Block> CERES_ROCKY_SAND = registerBlock("ceres_rocky_sand",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRAVEL)));

    public static final RegistryObject<Block> CERES_LIGHT_SAND = registerBlock("ceres_light_sand",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> CERES_LIGHT_ROCKY_SAND = registerBlock("ceres_light_rocky_sand",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRAVEL)));


    public static final RegistryObject<Block> ICY_DUST = registerBlock("icy_dust",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRAVEL)));

    public static final RegistryObject<Block> PHOBOS_STONE = registerBlock("phobos_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> DEIMOS_STONE = registerBlock("deimos_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> BROWN_GAS = registerBlock("brown_gas",
            () -> new BrownGasBlock(BlockBehaviour.Properties.of().noCollission().noLootTable().noOcclusion().isViewBlocking(GAMBlocks::never)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return GAMItems.ITEMS.register(name, () -> new BlockItem(block.get(), new  Item.Properties()));
    }

    public static void register(IEventBus eventBusbus) {
        BLOCKS.register(eventBusbus);
    }

}
