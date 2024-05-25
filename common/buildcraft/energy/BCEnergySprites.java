/*
 * Copyright (c) 2017 SpaceToad and the BuildCraft team
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of the MPL was not
 * distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/
 */

package buildcraft.energy;

import buildcraft.energy.client.sprite.AtlasSpriteFluid;
import buildcraft.energy.client.sprite.NonSwappableAtlasSpriteFluid;
import buildcraft.lib.BCLibConfig;
import buildcraft.lib.fluid.BCFluid;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BCEnergySprites {
    public static void fmlPreInit() {
        MinecraftForge.EVENT_BUS.register(BCEnergySprites.class);
    }

    @SubscribeEvent
    public static void onTextureStitchPre(TextureStitchEvent.Pre event) {
        TextureMap map = event.getMap();

        ResourceLocation[][] fromSprites = new ResourceLocation[3][2];
        for (int h = 0; h < 3; h++) {
            fromSprites[h][0] = new ResourceLocation("buildcraftenergy:blocks/fluids/heat_" + h + "_still");
            fromSprites[h][1] = new ResourceLocation("buildcraftenergy:blocks/fluids/heat_" + h + "_flow");
        }

        if (!BCLibConfig.useSwappableSprites) {
            for (BCFluid f : BCEnergyFluids.allFluids) {
                ResourceLocation[] sprites = fromSprites[f.getHeatValue()];
                map.setTextureEntry(new NonSwappableAtlasSpriteFluid(f.getStill().toString(), sprites[0], f));
                map.setTextureEntry(new NonSwappableAtlasSpriteFluid(f.getFlowing().toString(), sprites[1], f));
            }
            return;
        }

        for (BCFluid f : BCEnergyFluids.allFluids) {
            ResourceLocation[] sprites = fromSprites[f.getHeatValue()];
            map.setTextureEntry(new AtlasSpriteFluid(f.getStill().toString(), sprites[0], f));
            map.setTextureEntry(new AtlasSpriteFluid(f.getFlowing().toString(), sprites[1], f));
        }
    }
}
