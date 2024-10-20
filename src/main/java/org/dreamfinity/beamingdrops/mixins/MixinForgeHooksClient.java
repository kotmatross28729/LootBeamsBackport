package org.dreamfinity.beamingdrops.mixins;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import org.dreamfinity.beamingdrops.BeamRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value = ForgeHooksClient.class, priority = 1999)
public class MixinForgeHooksClient {

    @Inject(method = "renderEntityItem",
        at = @At(value = "TAIL"), remap = false)
    private static boolean renderEntityItem(EntityItem entity, ItemStack item, float bobing, float rotation, Random random, TextureManager engine, RenderBlocks renderBlocks, int count, CallbackInfoReturnable<Boolean> cir)
    {
        BeamRenderer.renderBeam(entity);
        return true;
    }

}
