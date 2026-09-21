package org.lightning323.terranova.datagen;


import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.lightning323.terranova.ItemInit;
import org.lightning323.terranova.TerraNova;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TerraNova.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ItemInit.ITEMS.getEntries().forEach(itemHolder -> generateSimpleItemModel(itemHolder.get()));
    }

    /**
     * Generates a flat item model where the texture name matches the item's registry ID.
     * Expects textures at assets/terranova/textures/item/[item_id].png
     */
    private void generateSimpleItemModel(Item item) {
        String path = BuiltInRegistries.ITEM.getKey(item).getPath();
        // Tools/swords render angled in-hand, so use the handheld parent for them.
        if (item == ItemInit.CREATIVE_SWORD.get()) {
            this.withExistingParent(path, mcLoc("item/handheld"))
                    .texture("layer0", modLoc("item/" + path));
        } else {
            this.basicItem(item);
        }
    }
}