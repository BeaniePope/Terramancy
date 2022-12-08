package com.github.BeaniePope.terramancy.item;
import com.github.BeaniePope.terramancy.item.complex.ImpetusDustItem;
import com.github.BeaniePope.terramancy.item.complex.MortarNPestleItem;
import net.minecraft.world.Container;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class modItems {
    private static final String MODID = "terramancy";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> MORTARNPESTLE = ITEMS.register("mortarnpestle",
            () -> new MortarNPestleItem(new Item.Properties().tab(ModCreativeModeTab.TERRAMANCY_TAB)));
    public static final RegistryObject<Item> IMPETUSDUST = ITEMS.register("impetusdust",
            () -> new ImpetusDustItem(new Item.Properties().tab(ModCreativeModeTab.TERRAMANCY_TAB)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(1)
                            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1F)
                            .alwaysEat().build())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}


