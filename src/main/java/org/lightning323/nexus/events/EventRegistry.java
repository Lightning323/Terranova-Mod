package org.lightning323.nexus.events;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.lightning323.nexus.items.shield.MaterialShieldRegistry;
import org.lightning323.nexus.PotionsRegistry;

public class EventRegistry {
    public static void setup(final FMLCommonSetupEvent event) {
        PotionsRegistry.setup();
//        PacketRegistry.setup();
        //Since we already use hints, we don't need this
//        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    public static void setupClient(final FMLClientSetupEvent event) {
        MaterialShieldRegistry.initShields();
    }
}
