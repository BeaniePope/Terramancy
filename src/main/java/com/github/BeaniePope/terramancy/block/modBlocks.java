package com.github.BeaniePope.terramancy.block;

import com.github.BeaniePope.terramancy.block.complex.FabricatorBlock;
import com.github.BeaniePope.terramancy.item.ModCreativeModeTab;
import com.github.BeaniePope.terramancy.item.modItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class modBlocks {
    private static final String MODID = "terramancy";
    private static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

//elon musk could never
    public static final RegistryObject<Block> FABRICATOR_BLOCK = registerBlock("fabricator_block",
            () -> new FabricatorBlock(BlockBehaviour.Properties.of(Material.METAL).strength(3f)),
            ModCreativeModeTab.TERRAMANCY_TAB);
//    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("gay",
//            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noCollission()),
//            ModCreativeModeTab.TERRAMANCY_TAB);

    public static <T extends Block> RegistryObject<T>  registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }



    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){

    return modItems.ITEMS.register(name, () -> new BlockItem(block.get(),
            new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }


}
