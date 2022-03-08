package com.moltenwolfcub.cosmetic_curios;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import com.moltenwolfcub.cosmetic_curios.init.ModItems;
import com.moltenwolfcub.cosmetic_curios.items.MainCreativeTab;
import com.moltenwolfcub.cosmetic_curios.render.curio.CurioLayers;
import com.moltenwolfcub.cosmetic_curios.render.curio.CurioRenderers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("cosmetic_curios")
public class CosmeticCurios
{
    
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "cosmetic_curios";
    public static final CreativeModeTab TAB = new MainCreativeTab();

    public CosmeticCurios() {
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onRegisterLayerDefinitions);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);

        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){}

    private void enqueueIMC(final InterModEnqueueEvent event){
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.HEAD.getMessageBuilder().build());
    }
    
    private void processIMC(final InterModProcessEvent event){}



    public void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        CurioLayers.register(event);
    }

    public void onClientSetup(FMLClientSetupEvent event) {
        CurioRenderers.register();
    }
}
