package org.dreamfinity.beamingdrops.asm;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import net.minecraft.launchwrapper.Launch;
import org.dreamfinity.beamingdrops.BeamingDrops;
import org.dreamfinity.beamingdrops.Config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@IFMLLoadingPlugin.Name("LBBEarlyMixins")
@IFMLLoadingPlugin.MCVersion("1.7.10")
public class LBBEarlyMixins implements IFMLLoadingPlugin, IEarlyMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.beamingdrops.early.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedCoreMods) {
        String configFolder = "config" + File.separator + BeamingDrops.MODID + File.separator;
        Config.loadEarlyMixinConfig(new File(Launch.minecraftHome, configFolder + "BeamingDropMixinsEarly.cfg"));
        boolean client = FMLLaunchHandler.side().isClient();
        List<String> mixins = new ArrayList<>();

        if(client) {
            mixins.add("MixinRenderItem");
            mixins.add("MixinForgeHooksClient");
        }

        return mixins;
    }

    @Override
    public String[] getASMTransformerClass() {
        return null;
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
