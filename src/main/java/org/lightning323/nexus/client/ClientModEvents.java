package org.lightning323.nexus.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.GameType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lightning323.nexus.client.utils.ClientUtils;
import org.lwjgl.glfw.GLFW;
import org.lightning323.nexus.client.utils.ClientGameSettings;
import org.lightning323.nexus.items.glowHelmet.GlowHelmet;

import static org.lightning323.nexus.Nexus.MOD_ID;
import static org.lightning323.nexus.Nexus.preInit;
import static org.lightning323.nexus.items.glowHelmet.GlowHelmet.MAX_GAMMA;

// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientModEvents {

    public static final String DEFAULT_CATEGORY = "key." + MOD_ID + ".default";
    public static final KeyMapping KEY_TOGGLE_NIGHT_VISION = new KeyMapping(
            "key." + MOD_ID + ".toggle_night_vision",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_N,
            DEFAULT_CATEGORY
    );

    // This nested class handles the MOD bus specifically
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ModBusEvents {
        @SubscribeEvent
        public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
            event.register(KEY_TOGGLE_NIGHT_VISION);
        }
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        boolean isRestricted = false;

        if(preInit.client_allowNightVisionSurvival == false) {
            var mc = Minecraft.getInstance();
            if (mc.player == null || mc.gameMode == null || mc.level == null) return;
            GameType gameMode = mc.gameMode.getPlayerMode();
            isRestricted = gameMode == GameType.SURVIVAL || gameMode == GameType.ADVENTURE;
        }

        if (!isRestricted && KEY_TOGGLE_NIGHT_VISION.consumeClick()) {
            if (ClientGameSettings.getGamma() >= MAX_GAMMA) {
                GlowHelmet.setNightVision(false);
                ClientUtils.showToast("Night Vision", "Night Vision Disabled");
            } else {
                GlowHelmet.setNightVision(true);
                ClientUtils.showToast("Night Vision", "Night Vision Enabled");
            }
        }
    }
}