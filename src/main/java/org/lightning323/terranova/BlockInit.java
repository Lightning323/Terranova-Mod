package org.lightning323.terranova;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TerraNova.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, TerraNova.MODID);

    /* // Example helper to easily uncomment and generate phantom/no-collision blocks
    private static DeferredBlock<Block> registerPhantomBlock(String name, BlockBehaviour.Properties properties) {
        DeferredBlock<Block> block = BLOCKS.register(name, () -> new Block(properties.noCollision().destroyTime(0.9F)));
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    // Uncomment these to instantly deploy your phantom blocks:
    public static final DeferredBlock<Block> PHANTOM_DIRT = registerPhantomBlock("phantom_dirt", BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT));
    public static final DeferredBlock<Block> PHANTOM_COBBLESTONE = registerPhantomBlock("phantom_cobblestone", BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE));
    public static final DeferredBlock<Block> PHANTOM_STONE = registerPhantomBlock("phantom_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final DeferredBlock<Block> PHANTOM_NETHERRACK = registerPhantomBlock("phantom_netherrack", BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK));
    public static final DeferredBlock<Block> PHANTOM_END_STONE = registerPhantomBlock("phantom_end_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE));
    public static final DeferredBlock<Block> PHANTOM_STONE_BRICKS = registerPhantomBlock("phantom_stone_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    public static final DeferredBlock<Block> PHANTOM_SANDSTONE = registerPhantomBlock("phantom_sandstone", BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE));
    public static final DeferredBlock<Block> PHANTOM_RED_SANDSTONE = registerPhantomBlock("phantom_red_sandstone", BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE));
    public static final DeferredBlock<Block> PHANTOM_SNOW = registerPhantomBlock("phantom_snow", BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK));
    */
}