package org.dreamfinity.beamingdrops.asm;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;
import org.spongepowered.asm.mixin.MixinEnvironment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@LateMixin
public class LBBLateMixins implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.beamingdrops.late.json";
    }
    public static final MixinEnvironment.Side side = MixinEnvironment.getCurrentEnvironment().getSide();

    public boolean IPLoaded = true;

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        if(!loadedMods.contains("itemphysic")) {
            IPLoaded = false;
        }

        List<String> mixins = new ArrayList<>();

        if (side == MixinEnvironment.Side.CLIENT) {
            if (IPLoaded) {
                mixins.add("MixinClientPhysic");
            }
        }

        return mixins;
    }
}
