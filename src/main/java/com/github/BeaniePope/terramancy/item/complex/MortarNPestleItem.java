package com.github.BeaniePope.terramancy.item.complex;

import com.github.BeaniePope.terramancy.item.modItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

import static net.minecraft.sounds.SoundEvents.ITEM_BREAK;

public class MortarNPestleItem extends Item{
    public MortarNPestleItem(Properties pProperties){
        super(pProperties.durability(50));
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        // Copy the original
        var result = itemStack.copy();
        // Damage it
        result.hurtAndBreak(10, ForgeHooks.getCraftingPlayer(), player -> {
            if (player != null) {
                player.level.playSound(null, player.getX(), player.getY(), player.getZ(), ITEM_BREAK, player.getSoundSource(), 1.0f, 1.0f);
            }
        });
        return result;
    }
}
