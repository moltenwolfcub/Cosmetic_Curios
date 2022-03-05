package com.moltenwolfcub.cosmetic_curios;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("cosmetic_curios")
public class CosmeticCurios
{
    
    public static final Logger LOGGER = LogManager.getLogger();

    public CosmeticCurios() {
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){ }
}
