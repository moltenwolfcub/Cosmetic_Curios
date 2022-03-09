package com.moltenwolfcub.cosmetic_curios.render.curio;

import com.moltenwolfcub.cosmetic_curios.CosmeticCurios;
import com.moltenwolfcub.cosmetic_curios.render.curio.model.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;

import java.util.function.Supplier;

public class CurioLayers {
    
    public static final ModelLayerLocation
            TOP_HAT = createLayerLocation("top_hat"),
            TIE = createLayerLocation("tie");

    public static ModelLayerLocation createLayerLocation(String name) {
        return new ModelLayerLocation(new ResourceLocation(CosmeticCurios.MOD_ID, name), name);
    }

    private static Supplier<LayerDefinition> layer(MeshDefinition mesh, int textureWidth, int textureHeight) {
        return () -> LayerDefinition.create(mesh, textureWidth, textureHeight);
    }

    private static void register(EntityRenderersEvent.RegisterLayerDefinitions event, ModelLayerLocation layerLocation, Supplier<LayerDefinition> layer) {
        event.registerLayerDefinition(layerLocation, layer);
    }

    public static void register(EntityRenderersEvent.RegisterLayerDefinitions event) {
        register(event, TOP_HAT, layer(HeadModel.createTopHat(), 128, 64));
        register(event, TIE, layer(HeadModel.createTie(), 16, 16));
    }
}
