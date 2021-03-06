package com.jtmnf.jquarry;

import com.jtmnf.jquarry.handler.JQuarryConfiguration;
import com.jtmnf.jquarry.init.JQuarryBlocks;
import com.jtmnf.jquarry.init.JQuarryItems;
import com.jtmnf.jquarry.init.JQuarryRecipes;
import com.jtmnf.jquarry.init.JQuarryTiles;
import com.jtmnf.jquarry.modload.GetModsDependencies;
import com.jtmnf.jquarry.proxy.ClientProxy;
import com.jtmnf.jquarry.proxy.IProxy;
import com.jtmnf.jquarry.reference.JQuarryReference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Mod(modid = JQuarryReference.MOD_ID, name = JQuarryReference.MOD_NAME, version = JQuarryReference.VERSION)
public class JQuarry {

    @Mod.Instance(JQuarryReference.MOD_ID)
    public static JQuarry instance;

    @SidedProxy(clientSide = JQuarryReference.CLIENT_PROXY_CLASS, serverSide = JQuarryReference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    private File configOres;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        /* Extra Ores */
        configOres = event.getModConfigurationDirectory();

        JQuarryConfiguration.initConfigFiles(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new JQuarryConfiguration());

        JQuarryBlocks.initJQuarryBlocks();
        JQuarryItems.initJQuarryItems();
        JQuarryTiles.initJQuarryTiles();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        File file = new File(configOres.getAbsolutePath()+"/JQuarry.json");
        List<String> list = null;

        if(file.exists() && !file.isDirectory()){
            list = GetModsDependencies.initDependencies(file, file.getAbsolutePath());
        }

        if(list != null){
            JQuarryBlocks.initJQuarryDependencies(list);
        }

        JQuarryRecipes.initRecipes();

        ClientProxy.setCustomRenderers();
    }

    @Mod.EventHandler
    public void posInit(FMLPostInitializationEvent event){
    }
}
