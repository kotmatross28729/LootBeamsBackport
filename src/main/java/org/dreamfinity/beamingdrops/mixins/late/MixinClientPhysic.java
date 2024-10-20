package org.dreamfinity.beamingdrops.mixins.late;

import com.creativemd.itemphysic.physics.ClientPhysic;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.IIcon;
import org.dreamfinity.beamingdrops.BeamRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ClientPhysic.class, priority = 1999)
public class MixinClientPhysic {

    @Inject(method = "renderDroppedItem(Lnet/minecraft/entity/item/EntityItem;Lnet/minecraft/util/IIcon;IFFFFI)V",
        at = @At(value = "TAIL"), remap = false)
    private static void renderDroppedItem(EntityItem item, IIcon par2Icon, int par3, float par4, float par5, float par6, float par7, int pass, CallbackInfo ci)
    {
        BeamRenderer.renderBeam(item);
    }
}
