package org.lightning323.nexus.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import org.lightning323.nexus.items.glowHelmet.GlowHelmet;

import java.util.function.Supplier;

public class GlowHelmetPacket {
    private final boolean allowNightVision;

    public GlowHelmetPacket(boolean allowNightVision) {
        this.allowNightVision = allowNightVision;
    }

    public static void encode(GlowHelmetPacket msg, FriendlyByteBuf buf) {
        buf.writeBoolean(msg.allowNightVision);
    }

    public static GlowHelmetPacket decode(FriendlyByteBuf buf) {
        boolean allowNightVision = buf.readBoolean();
        return new GlowHelmetPacket(allowNightVision);
    }

    public static void handle(GlowHelmetPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player != null) {
                GlowHelmet.setNightVision(msg.allowNightVision);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
