package org.lightning323.terranova;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(TerraNova.MODID)
public class TerraNova {
    public static final String MODID = "terranova";

    // Create a deferred register for our custom creative tab
//    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
//            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
//
//    // Grouping all items into a dedicated "TerraNova Mod" tab
//    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("terranova_tab", () -> CreativeModeTab.builder()
//            .title(Component.translatable("itemGroup.terranova"))
//            .icon(() -> new ItemStack(ItemInit.WARP_CORE.get())) // Set Warp Core as icon
//            .displayItems((parameters, output) -> {
//                // Items
//                ItemInit.ITEMS.getEntries().forEach(holder -> output.accept(holder.get()));
//                // Blocks (Only if blocks get uncommented/registered in the future)
//                BlockInit.ITEMS.getEntries().forEach(holder -> output.accept(holder.get()));
//            }).build());

    public TerraNova(IEventBus modEventBus) {
        // Register everything to the bus
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        BlockInit.ITEMS.register(modEventBus);
//        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
