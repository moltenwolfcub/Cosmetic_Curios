package com.moltenwolfcub.cosmetic_curios.render.curio;

import com.moltenwolfcub.cosmetic_curios.init.ModItems;
import com.moltenwolfcub.cosmetic_curios.render.curio.model.HeadModel;
import com.moltenwolfcub.cosmetic_curios.render.curio.renderers.CurioRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

public class CurioRenderers {
    
    public static ModelPart bakeLayer(ModelLayerLocation layerLocation) {
        return Minecraft.getInstance().getEntityModels().bakeLayer(layerLocation);
    }

    public static void register() {
        CuriosRendererRegistry.register(ModItems.TOP_HAT.get(), () -> new CurioRenderer("top_hat", new HeadModel(bakeLayer(CurioLayers.TOP_HAT))));
    }
}
