package com.github.BeaniePope.terramancy.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

import static net.minecraftforge.versions.forge.ForgeVersion.MOD_ID;

public class modTags {
    public static class Blocks{


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
    public static class Items{




        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }

    }
}
