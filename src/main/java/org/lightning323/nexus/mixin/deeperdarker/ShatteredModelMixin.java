package org.lightning323.nexus.mixin.deeperdarker;

import com.kyanite.deeperdarker.client.model.ShatteredModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = ShatteredModel.class, remap = false)
public class ShatteredModelMixin {

    /**
     * @author YourName
     * @reason Replacing the model geometry entirely.
     */
    @Overwrite
    public static LayerDefinition createBodyModel() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition parts = mesh.getRoot();

        PartDefinition root = parts.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(16, 16).addBox(-4.0F, -13.0F, -2.0F, 8.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
                        .texOffs(37, 6).mirror().addBox(0.0F, -11.0F, 2.0F, 0.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
                PartPose.offset(0.0F, -13.0F, 0.0F));

        body.addOrReplaceChild("head", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                        .texOffs(32, 0).addBox(-12.0F, -11.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                        .texOffs(40, 0).mirror().addBox(4.0F, -11.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
                PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, 0.0F));

        arms.addOrReplaceChild("right_arm", CubeListBuilder.create()
                        .texOffs(0, 16)
                        .addBox(-4.0F, -2.0F, -2.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
                        .texOffs(43, 8)
                        .addBox(-4.0F, 11.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-4.0F, 0.0F, 0.0F));

        arms.addOrReplaceChild("left_arm", CubeListBuilder.create()
                        .texOffs(0, 16)
                        .addBox(0.0F, -2.0F, -2.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
                        .texOffs(43, 8)
                        .addBox(1.0F, 5.0F, -1.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0F, 0.0F, 0.0F));

        PartDefinition legs = root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 0.0F));

        legs.addOrReplaceChild("right_leg", CubeListBuilder.create()
                        .texOffs(16, 33)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-2.0F, 0.0F, 0.0F));

        legs.addOrReplaceChild("left_leg", CubeListBuilder.create()
                        .texOffs(16, 33)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(2.0F, 0.0F, 0.0F));

        return LayerDefinition.create(mesh, 64, 64);
    }
}