package org.lightning323.terranova;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TerraNova.MODID);

    // Helpers to quickly generate properties based on stack size and fire status
    private static Item.Properties normal(int stackSize) {
        return new Item.Properties().stacksTo(stackSize);
    }

    private static Item.Properties fireproof(int stackSize) {
        return new Item.Properties().stacksTo(stackSize).fireResistant();
    }

    // ========================================================================
    // WORLDEDIT WANDS
    // ========================================================================
    public static final DeferredItem<Item> WORLDEDIT_WAND = ITEMS.register("worldedit_wand", () -> new Item(normal(1)));
    public static final DeferredItem<Item> WORLDEDIT_NAV = ITEMS.register("worldedit_nav", () -> new Item(normal(1)));

    // ========================================================================
    // NORTHSTAR
    // ========================================================================
//    public static final DeferredItem<Item> COMPRESSED_SAND_BAR = ITEMS.register("compressed_sand_bar", () -> new Item(normal(64)));
    public static final DeferredItem<Item> HEAT_TILE = ITEMS.register("heat_tile", () -> new Item(normal(64)));
//    public static final DeferredItem<Item> SAND_TILE = ITEMS.register("sand_tile", () -> new Item(normal(64)));

    // Witherite (Harbinger)
    public static final DeferredItem<Item> WITHERITE_POWDER = ITEMS.register("witherite_powder", () -> new Item(fireproof(64)));
    public static final DeferredItem<Item> BLACK_NETHERITE_INGOT = ITEMS.register("black_netherite_ingot", () -> new Item(fireproof(64)));

    // Abyssal (Leviathan)
    public static final DeferredItem<Item> ABYSSAL_DUST = ITEMS.register("abyssal_dust", () -> new Item(fireproof(64)));
    public static final DeferredItem<Item> ABYSSAL_INGOT = ITEMS.register("abyssal_ingot", () -> new Item(fireproof(64)));
    public static final DeferredItem<Item> ABYSSAL_PEARL = ITEMS.register("abyssal_pearl", () -> new Item(fireproof(64)));

    // Cursium (Necromancer)
    public static final DeferredItem<Item> CURSIUM_DUST = ITEMS.register("cursium_dust", () -> new Item(fireproof(64)));
    public static final DeferredItem<Item> CURSIUM_PEARL = ITEMS.register("cursium_pearl", () -> new Item(fireproof(64)));

    // Monstrous (Nether golem)
    public static final DeferredItem<Item> MONSTROUS_DUST = ITEMS.register("monstrous_dust", () -> new Item(fireproof(64)));
    public static final DeferredItem<Item> MONSTROUS_PEARL = ITEMS.register("monstrous_pearl", () -> new Item(fireproof(64)));
//    public static final DeferredItem<Item> MONSTROUS_INGOT = ITEMS.register("monstrous_ingot", () -> new Item(fireproof(64)));

    // Ancient Remnant
    public static final DeferredItem<Item> ANCIENT_DUST = ITEMS.register("ancient_dust", () -> new Item(fireproof(64)));
    public static final DeferredItem<Item> ANCIENT_PEARL = ITEMS.register("ancient_pearl", () -> new Item(fireproof(64)));

    // End Guardian
    public static final DeferredItem<Item> VOID_CORE_DUST = ITEMS.register("void_core_dust", () -> new Item(fireproof(64)));
    public static final DeferredItem<Item> VOID_INGOT = ITEMS.register("void_ingot", () -> new Item(fireproof(64)));
    public static final DeferredItem<Item> VOID_PEARL = ITEMS.register("void_pearl", () -> new Item(fireproof(64)));

    // Ignus
    public static final DeferredItem<Item> IGNITIUM_POWDER = ITEMS.register("ignitium_powder", () -> new Item(fireproof(64)));
    public static final DeferredItem<Item> IGNITIUM_INGOT = ITEMS.register("ignitium_ingot", () -> new Item(fireproof(64)));
    public static final DeferredItem<Item> IGNITIUM_PEARL = ITEMS.register("ignitium_pearl", () -> new Item(fireproof(64)));

    // Other Bosses
    public static final DeferredItem<Item> PYROTIDE_SHARD = ITEMS.register("pyrotide_shard", () -> new Item(fireproof(64)));
    public static final DeferredItem<Item> HYDRONITE_SHARD = ITEMS.register("hydronite_shard", () -> new Item(fireproof(64)));

    // ========================================================================
    // CREATE ITEMS
    // ========================================================================
//    public static final DeferredItem<Item> PRECISION_COMPONENT = ITEMS.register("precision_component", () -> new Item(normal(64)));
//    public static final DeferredItem<Item> PRECISION_MACHINE = ITEMS.register("precision_machine", () -> new Item(normal(64)));
//    public static final DeferredItem<Item> WARP_CORE = ITEMS.register("warp_core", () -> new Item(normal(16)));
}