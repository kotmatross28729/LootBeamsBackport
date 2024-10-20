package org.dreamfinity.beamingdrops;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {
    static Configuration config;
    private static final String COMMON = "Beam settings";
    public static boolean needRenderBeam = true;
    public static boolean useHighResBeam = true;
    public static boolean useRotatingBeam = true;
    public static boolean useFloatingBeam = true;
    public static double beamDiameter = 0.25;
    public static double beamHeight = 1.5;
    public static String[]  itemBlackList;
    public static boolean isWhitelist = false;

    public static boolean useDepthMask = false;

    public static void loadEarlyMixinConfig(File configFile) {
        Configuration config = new Configuration(configFile);

        needRenderBeam = config.getBoolean("needRenderBeam", COMMON, true,  "Render beam above items or not");
        useHighResBeam = config.getBoolean("useHighResBeam", COMMON, true,  "Use high-res (256x256) beam texture or low-res(16x16)");
        useRotatingBeam = config.getBoolean("useRotatingBeam", COMMON, true,  "Rotate beam over time (like beacon's beam)");
        useFloatingBeam = config.getBoolean("useFloatingBeam", COMMON, true,  "Slightly float beam over time");
        beamDiameter = config.getFloat("beamDiameter", COMMON, 0.25f, 0.05f, 3.0f, "Beam diameter");
        beamHeight = config.getFloat("beamHeight", COMMON, 4.0f, 0.5f, 32.0f, "Beam height (in blocks)");
        itemBlackList = config.getStringList("itemBlackList", COMMON, new String[] {}, "Items not to render beam for");
        isWhitelist = config.getBoolean("isWhitelist", COMMON, false, "If the beam blacklist should be used as a whitelist instead");
        useDepthMask = config.getBoolean("useDepthMask", COMMON, false, "I don't know what this is for, but as a side effect, the beams are rendered BEHIND the tileentity, even if the item itself is IN FRONT of them");

        if(config.hasChanged()) {
            config.save();
        }
    }
}
