package org.lightning323.nexus;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.lightning323.nexus.blocks.angelScaffolding.ItemScaffolding;
import org.lightning323.nexus.items.glowHelmet.GlowHelmet;
import org.lightning323.nexus.materials.ModToolMaterials;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, Nexus.MOD_ID);

    //Misc
//    public static final RegistryObject<Item> SNOWFLAKE = ITEMS.register("snowflake", () -> new Item(new Item.Properties()));
////    public static final RegistryObject<Item> BLUE_SNOWFLAKE = ITEMS.register("blue_snowflake", () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> GOLD_SNOWFLAKE = ITEMS.register("gold_snowflake", () -> new Item(new Item.Properties()));
//
//    public static final RegistryObject<Item> GEM_PRISMARINE = ITEMS.register("gem_prismarine", () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> GEM_AMETHYST = ITEMS.register("gem_amethyst", () -> new Item(new Item.Properties()));
////    public static final RegistryObject<Item> GEM_TANZANITE = ITEMS.register("gem_tanzanite", () -> new Item(new Item.Properties()));


    //Scaffolding
    public static final RegistryObject<Item> SCAFFOLD_FRAGILE = ITEMS.register("scaffold_fragile", () -> new ItemScaffolding(BlockRegistry.SCAFFOLD_FRAGILE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCAFFOLD_RESPONSIVE = ITEMS.register("scaffold_responsive", () -> new ItemScaffolding(BlockRegistry.SCAFFOLD_RESPONSIVE.get(), new Item.Properties()));

    //Cooper tools and armor
//    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(ModToolMaterials.COPPER, 1, -2.8f, new Item.Properties()));
//    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(ModToolMaterials.COPPER, -1, -2f, new Item.Properties()));
//    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(ModToolMaterials.COPPER, 3, -2.4f, (new Item.Properties())));
//    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(ModToolMaterials.COPPER, 1, -2.8f, new Item.Properties()));
//    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(ModToolMaterials.COPPER, 7, -3.4f, new Item.Properties()));
//
//    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots", () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR, ArmorItem.Type.BOOTS, new Item.Properties()));
//    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet", () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR, ArmorItem.Type.HELMET, new Item.Properties()));
//    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
//    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> GLOW_HELMET = ITEMS.register("glowing_helmet", () -> new GlowHelmet());

    //Creative gear
    public static final RegistryObject<Item> CREATIVE_SWORD = ITEMS.register("creative_sword", () -> new SwordItem(ModToolMaterials.CREATIVE, 3, -2.4F, (new Item.Properties())));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static void addToCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
        } else if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ItemRegistry.GLOW_HELMET);
        } else if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ItemRegistry.SCAFFOLD_FRAGILE);
            event.accept(ItemRegistry.SCAFFOLD_RESPONSIVE);

        } else if (event.getTabKey() == CreativeModeTabs.OP_BLOCKS) {
            event.accept(ItemRegistry.CREATIVE_SWORD);
        } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
        }
    }
}
