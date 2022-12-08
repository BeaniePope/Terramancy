package com.github.BeaniePope.terramancy.item.complex;

import com.github.BeaniePope.terramancy.item.modItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MortarNPestleItem extends Item{
    public MortarNPestleItem(Properties pProperties){
        super(pProperties);
    }


    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return super.getContainerItem(new ItemStack(modItems.MORTARNPESTLE.get()));
    }
}
