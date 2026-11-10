package com.twojnick.customframes;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CustomFramesMod implements ModInitializer {
    public static final String MOD_ID = "customframes";

    public static final String[] COLORS = {
        "white", "orange", "magenta", "light_blue", "yellow", "lime",
        "pink", "gray", "light_gray", "cyan", "purple", "blue",
        "brown", "green", "red", "black"
    };

    @Override
    public void onInitialize() {
        for (String color : COLORS) {
            registerBlockVariants(color + "_concrete");
            registerBlockVariants(color + "_terracotta");
            registerBlockVariants(color + "_wool");
        }
    }

    private void registerBlockVariants(String baseName) {
        Block slab = new SlabBlock(AbstractBlock.Settings.create());
        Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, baseName + "_slab"), slab);

        Block stairs = new StairsBlock(slab.getDefaultState(), AbstractBlock.Settings.create());
        Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, baseName + "_stairs"), stairs);
    }
}