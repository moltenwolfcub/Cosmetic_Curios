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

    public BeltModel(ModelPart part, Function<ResourceLocation, RenderType> renderType) {
        super(part, renderType);
    }

    public BeltModel(ModelPart part) {
        this(part, RenderType::entityCutoutNoCull);
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
                        .addBox(-4, 0, -2, 8, 12, 4, deformation),
                PartPose.ZERO
        );

        mesh.getRoot().getChild("body").addOrReplaceChild(
                "charm",
                charm,
                PartPose.ZERO
        );

        return mesh;
    }


    //actual hats
    public static MeshDefinition createLeatherBelt() {
        CubeListBuilder belt = CubeListBuilder.create();

        //base
        belt.texOffs(0, 0);
        belt.addBox(-8, -8, -8, 16, 16, 16);

        return createBelt(belt);
    }
}
