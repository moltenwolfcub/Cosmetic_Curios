package com.moltenwolfcub.cosmetic_curios.init;

import com.moltenwolfcub.cosmetic_curios.CosmeticCurios;
import com.moltenwolfcub.cosmetic_curios.items.itemBases.ItemBaseNonStackable;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CosmeticCurios.MOD_ID);
    
    public static final RegistryObject<Item> TOP_HAT = ITEMS.register("top_hat", ItemBaseNonStackable::new);
}
