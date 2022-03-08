package com.moltenwolfcub.cosmetic_curios.items.itemBases;

import com.moltenwolfcub.cosmetic_curios.CosmeticCurios;

import net.minecraft.world.item.Item;

public class ItemBaseNonStackable extends Item {

    public ItemBaseNonStackable() {
        super(new Item.Properties().tab(CosmeticCurios.TAB).stacksTo(1));
    }
    
}
