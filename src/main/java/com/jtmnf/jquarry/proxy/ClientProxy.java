package com.jtmnf.jquarry.proxy;

import com.jtmnf.jquarry.render.RenderQuarryTextures;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
    public static int renderQuarryProxy;
    public static int renderQuarry;

    public static void setCustomRenderers(){
        renderQuarryProxy = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderQuarryTextures());
    }
}
