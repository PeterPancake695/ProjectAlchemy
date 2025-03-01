package net.peterpancake.projectalchemy.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.peterpancake.projectalchemy.ProjectAlchemy;
import net.peterpancake.projectalchemy.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectAlchemy.MOD_ID);

    public static final Supplier<CreativeModeTab> PROJECTALCHEMY_TAB = CREATIVE_MODE_TAB.register("projectalchemy_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.PHILOSOPHERS_STONE.get()))
                    .title(Component.translatable("creativetab.projectalchemy"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PHILOSOPHERS_STONE);
                        output.accept(ModItems.COVALENCE_DUST_LOW);
                        output.accept(ModItems.COVALENCE_DUST_MEDIUM);
                        output.accept(ModItems.COVALENCE_DUST_HIGH);
                        output.accept(ModItems.ALCHEMICAL_COAL);
                        output.accept(ModItems.MOBIUS_FUEL);
                        output.accept(ModItems.AETERNALIS_FUEL);
                        output.accept(ModItems.DARK_MATTER);
                        output.accept(ModItems.RED_MATTER);

                        output.accept(ModBlocks.ALCHEMICAL_COAL_BLOCK);
                        output.accept(ModBlocks.AETERNALIS_FUEL_BLOCK);
                        output.accept(ModBlocks.MOBIUS_FUEL_BLOCK);
                        output.accept(ModBlocks.DARK_MATTER_BLOCK);
                        output.accept(ModBlocks.RED_MATTER_BLOCK);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
