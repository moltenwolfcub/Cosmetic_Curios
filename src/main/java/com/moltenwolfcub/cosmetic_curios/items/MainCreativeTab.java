package com.moltenwolfcub.cosmetic_curios.items;

import com.moltenwolfcub.cosmetic_curios.CosmeticCurios;
import com.moltenwolfcub.cosmetic_curios.init.ModItems;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MainCreativeTab extends CreativeModeTab {
    public MainCreativeTab() {
        super(CosmeticCurios.MOD_ID);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.TOP_HAT.get());
    }
}
