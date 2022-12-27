package com.github.BeaniePope.terramancy.block.event.loot;

import com.github.BeaniePope.terramancy.recipe.FabricatorRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.github.BeaniePope.terramancy.item.modItems.MODID;


@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventsBusEvents {


    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event){
        Registry.register(Registry.RECIPE_TYPE, FabricatorRecipe.Type.ID, FabricatorRecipe.Type.INSTANCE);
    }

}
