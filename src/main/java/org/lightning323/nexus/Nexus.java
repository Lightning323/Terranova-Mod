package org.lightning323.nexus;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lightning323.nexus.potions.PotionsRegistry;
import org.slf4j.Logger;
import org.lightning323.nexus.effects.EffectRegistry;
import org.lightning323.nexus.events.EventRegistry;
import org.lightning323.nexus.network.NetworkHandler;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Nexus.MOD_ID)
public class Nexus {
    public static final String MOD_ID = "nexus";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final PreInitConfig preInit = new PreInitConfig();

    public Nexus() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(EventRegistry::setup);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.register(modEventBus);
        BlockRegistry.register(modEventBus);
        EffectRegistry.register(modEventBus);
        PotionsRegistry.register(modEventBus);


        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        NetworkHandler.registerMessages();
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        ItemRegistry.addToCreative(event);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }


}
