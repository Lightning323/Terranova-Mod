package org.lightning323.nexus;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.lightning323.nexus.blocks.angelScaffolding.BlockScaffolding;
import org.lightning323.nexus.blocks.angelScaffolding.BlockScaffoldingResponsive;

import java.util.function.Supplier;

import static org.lightning323.nexus.Nexus.MOD_ID;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static final RegistryObject<Block> SCAFFOLD_FRAGILE = BLOCKS.register("scaffold_fragile", () -> new BlockScaffolding(Block.Properties.of(), true));
    public static final RegistryObject<Block> SCAFFOLD_RESPONSIVE = BLOCKS.register("scaffold_responsive", () -> new BlockScaffoldingResponsive(Block.Properties.of(), false));

    private static <T extends Block> RegistryObject<T> registerBlockAndItem(String name, Supplier<T> block) {
        RegistryObject<T> blockObject = BLOCKS.register(name, block); // Register the block
        ItemRegistry.ITEMS.register(name, () -> new BlockItem(blockObject.get(), new Item.Properties())); // Register the item
        return blockObject;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
