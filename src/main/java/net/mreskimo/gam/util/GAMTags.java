package net.mreskimo.gam.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.mreskimo.gam.GAM;

public class GAMTags {
    public static class Blocks {
        public static final TagKey<Block> CERES_REPLACEABLE = tag("ceres_replaceable");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(GAM.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(GAM.MOD_ID, name));
        }
    }
}
