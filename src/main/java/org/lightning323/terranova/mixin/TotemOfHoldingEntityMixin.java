package org.lightning323.terranova.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.violetmoon.quark.addons.oddities.entity.TotemOfHoldingEntity;

@Mixin(TotemOfHoldingEntity.class)
public class TotemOfHoldingEntityMixin {

    /**
     * The player doesnt have to hit the totem of holding 15 times just to drop everything.
     * They can just hit it once!
     * @param a
     * @param b
     * @return
     */
    @Redirect(
        method = "skipAttackInteraction",
        at = @At(
            value = "INVOKE",
            target = "Ljava/lang/Math;min(II)I"
        )
    )
    private int astral$removeTotemDropLimit(int a, int b) {
        return a;
    }
}