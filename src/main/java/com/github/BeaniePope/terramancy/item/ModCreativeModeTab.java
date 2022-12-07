package com.github.BeaniePope.terramancy.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TERRAMANCY_TAB = new CreativeModeTab("terramancytab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(modItems.MORTARNPESTLE.get());
        }
    };
}
