package net.peterpancake.projectalchemy.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.peterpancake.projectalchemy.ProjectAlchemy;
import net.peterpancake.projectalchemy.item.custom.PhilosophersStoneItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ProjectAlchemy.MOD_ID);

    public static final DeferredItem<Item> DARK_MATTER = ITEMS.register("dark_matter",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RED_MATTER = ITEMS.register("red_matter",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PHILOSOPHERS_STONE = ITEMS.register("philosophers_stone",
            () -> new PhilosophersStoneItem(new Item.Properties()
                    .stacksTo(1)
                    .rarity(Rarity.EPIC)
                    ));
    public static final DeferredItem<Item> ALCHEMICAL_COAL = ITEMS.register("alchemical_coal",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MOBIUS_FUEL = ITEMS.register("mobius_fuel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> AETERNALIS_FUEL = ITEMS.register("aeternalis_fuel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COVALENCE_DUST_HIGH = ITEMS.register("covalence_dust_high",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COVALENCE_DUST_LOW = ITEMS.register("covalence_dust_low",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COVALENCE_DUST_MEDIUM = ITEMS.register("covalence_dust_medium",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
