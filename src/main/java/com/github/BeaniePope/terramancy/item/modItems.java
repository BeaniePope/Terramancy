package com.github.BeaniePope.terramancy.item;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class modItems {
    private static final String MODID = "terramancy";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> MORTARNPESTLE = ITEMS.register("mortarnpestle", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TERRAMANCY_TAB)));
    public static final RegistryObject<Item> IMPETUSDUST = ITEMS.register("impestusdust", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TERRAMANCY_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
