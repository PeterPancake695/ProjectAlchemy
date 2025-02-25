package net.peterpancake.projectalchemy.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.peterpancake.projectalchemy.ProjectAlchemy;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ProjectAlchemy.MOD_ID);

    public static final DeferredItem<Item> DARK_MATTER = ITEMS.register("dark_matter",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RED_MATTER = ITEMS.register("red_matter",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PHILOSOPHERS_STONE = ITEMS.register("philosophers_stone",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
