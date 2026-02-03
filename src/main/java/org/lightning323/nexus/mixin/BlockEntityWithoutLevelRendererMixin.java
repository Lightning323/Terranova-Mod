package org.lightning323.nexus.mixin;

import net.minecraft.client.model.ShieldModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.lightning323.nexus.utils.mixin.I_BlockEntityWithoutLevelRenderer;

@Mixin(net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer.class)
public class BlockEntityWithoutLevelRendererMixin implements I_BlockEntityWithoutLevelRenderer {

    @Shadow
    private ShieldModel shieldModel;

    @Override
    public ShieldModel getShieldModel() {
        return shieldModel;
    }
}
