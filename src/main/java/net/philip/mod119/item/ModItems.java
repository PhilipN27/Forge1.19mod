package net.philip.mod119.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.philip.mod119.ModPn;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModPn.MOD_ID);

    public static final RegistryObject<Item> IGNITIUM = ITEMS.register("ignitium",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static void register (IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
