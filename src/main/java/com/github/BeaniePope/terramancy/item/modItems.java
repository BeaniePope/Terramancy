package com.github.BeaniePope.terramancy.item;
import com.github.BeaniePope.terramancy.item.complex.MortarNPestleItem;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class modItems {
    private static final String MODID = "terramancy";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> MORTARNPESTLE = ITEMS.register("mortarnpestle",
            () -> new MortarNPestleItem(new Item.Properties().tab(ModCreativeModeTab.TERRAMANCY_TAB)));
    public static final RegistryObject<Item> IMPETUSDUST = ITEMS.register("impetusdust",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TERRAMANCY_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}


