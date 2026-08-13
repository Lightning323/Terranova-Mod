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

    public TerraNova(IEventBus modEventBus) {
        ItemInit.register(modEventBus);
    }
}
