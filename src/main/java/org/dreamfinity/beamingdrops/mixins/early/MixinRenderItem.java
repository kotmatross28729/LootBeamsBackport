package org.dreamfinity.beamingdrops.mixins.early;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.IIcon;
import org.dreamfinity.beamingdrops.BeamRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RenderItem.class, priority = 1999)
public class MixinRenderItem {
//Bytecode reading simulator: part 2
    @Inject(method = "renderDroppedItem(Lnet/minecraft/entity/item/EntityItem;Lnet/minecraft/util/IIcon;IFFFFI)V",
        at = @At(value = "TAIL"), remap = false) //Why the fuck we can't make remap on vanilla method? Don't we HAVE to do this, huh?
    private void renderDroppedItem(EntityItem p_77020_1_, IIcon p_77020_2_, int p_77020_3_, float p_77020_4_, float p_77020_5_, float p_77020_6_, float p_77020_7_, int pass, CallbackInfo ci)
    {
        BeamRenderer.renderBeam(p_77020_1_);
    }
}
