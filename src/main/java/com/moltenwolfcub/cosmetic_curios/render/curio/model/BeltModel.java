package com.moltenwolfcub.cosmetic_curios.render.curio.model;

import java.util.function.Function;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class BeltModel extends HumanoidModel<LivingEntity> {

    protected final ModelPart charm = body.getChild("charm");

    private final float xOffset;
    private final float zOffset;
    private final float rotation;

    public BeltModel(ModelPart part, Function<ResourceLocation, RenderType> renderType, float xOffset, float zOffset, float rotation) {
        super(part, renderType);
        this.xOffset = xOffset;
        this.zOffset = zOffset;
        this.rotation = rotation;
    }

    public BeltModel(ModelPart part, float xOffset, float zOffset, float rotation) {
        this(part, RenderType::entityCutoutNoCull, xOffset, zOffset, rotation);
    }

    public void setCharmPosition(int slot) {
        float xOffset = slot % 2 == 0 ? this.xOffset : -this.xOffset;
        float zOffset = slot % 4 < 2 ? this.zOffset : -this.zOffset;
        charm.setPos(xOffset, 9, zOffset);

        float rotation = slot % 4 < 2 ? 0 : (float) -Math.PI;
        rotation += slot % 2 == 0 ^ slot % 4 >= 2 ? this.rotation : -this.rotation;
        charm.yRot = rotation;
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of();
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(body);
    }

    private static MeshDefinition createBelt(CubeListBuilder charm) {
        CubeDeformation deformation = new CubeDeformation(0.5F);
        MeshDefinition mesh = createMesh(CubeDeformation.NONE, 0);

        mesh.getRoot().addOrReplaceChild(
                "body",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(0, 0, 0, 0, 0, 0, deformation),
                        //.addBox(-4, 0, -2, 8, 12, 4, deformation)
                PartPose.ZERO
        );

        mesh.getRoot().getChild("body").addOrReplaceChild(
                "charm",
                charm,
                PartPose.ZERO
        );

        return mesh;
    }


    //actual belts
    public static MeshDefinition createLeatherBelt() {
        CubeListBuilder charm = CubeListBuilder.create();

        charm.texOffs(0, 0);
        charm.addBox(-5, 0, -3, 10, 2.5f, 6);

        return createBelt(charm);
    }
}
