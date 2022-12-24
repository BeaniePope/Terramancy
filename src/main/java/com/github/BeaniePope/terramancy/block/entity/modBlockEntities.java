package com.github.BeaniePope.terramancy.block.entity;

import com.github.BeaniePope.terramancy.block.entity.complex.FabricatorBlockEntity;
import com.github.BeaniePope.terramancy.block.modBlocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.BeaniePope.terramancy.item.modItems.MODID;


public class modBlockEntities {
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MODID);

    public static final RegistryObject<BlockEntityType<FabricatorBlockEntity>> FABRICATOR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("fabricator_block_entity", () ->
                    BlockEntityType.Builder.of(FabricatorBlockEntity::new,
                            modBlocks.FABRICATOR_BLOCK.get()).build(null));


    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
