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

public class HeadModel extends HumanoidModel<LivingEntity> {

    public HeadModel(ModelPart part, Function<ResourceLocation, RenderType> renderType) {
        super(part, renderType);
    }

    public HeadModel(ModelPart part) {
        this(part, RenderType::entityCutoutNoCull);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(head);
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of();
    }

    public static MeshDefinition createEmptyHat(CubeListBuilder head) {
        MeshDefinition mesh = createMesh(CubeDeformation.NONE, 0);

        mesh.getRoot().addOrReplaceChild(
                "head",
                head,
                PartPose.ZERO
        );

        return mesh;
    }

    public static MeshDefinition createHat(CubeListBuilder head) {
        CubeDeformation deformation = new CubeDeformation(0.5F);

        head.texOffs(0, 0);
        head.addBox(-4, -8, -4, 8, 8, 8, deformation);

        return createEmptyHat(head);
    }

    public static MeshDefinition createDiagonalHat(CubeListBuilder head, CubeListBuilder diagonalParts, String partName) {
        MeshDefinition mesh = createHat(head);

        mesh.getRoot().getChild("head").addOrReplaceChild(
                partName,
                diagonalParts,
                PartPose.rotation(45 * (float) Math.PI / 180, 0, 0)
        );

        return mesh;
    }


    //actual hats
    public static MeshDefinition createTopHat() {
        CubeListBuilder head = CubeListBuilder.create();

        //base
        head.texOffs(0, 0);
        head.addBox(-8, -12, -8, 16, 4, 16);

        //ribbon
        head.texOffs(30, 29);
        head.addBox(-5, -14, -5, 10, 2, 10);

        //main
        head.texOffs(0, 20);
        head.addBox(-5, -23, -5, 10, 9, 10);

        return createEmptyHat(head);
    }
}
