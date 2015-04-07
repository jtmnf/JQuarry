package com.jtmnf.jquarry.handler;

import com.jtmnf.jquarry.reference.JQuarryReference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class JQuarryConfiguration {

    public static Configuration configuration;

    public static boolean requireEnergy = true;
    public static int rfEnergy = 20;
    public static int maxEnergyStored = 1000000;

    public static String dirtQuarry = Block.blockRegistry.getNameForObject(Blocks.dirt);
    public static String gravelQuarry = Block.blockRegistry.getNameForObject(Blocks.gravel);
    public static String sandQuarry = Block.blockRegistry.getNameForObject(Blocks.sand);
    public static String stoneQuarry = Block.blockRegistry.getNameForObject(Blocks.stone);

    public static void initConfigFiles(File configFile){

        if (configuration == null){
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){

        if(event.modID.equalsIgnoreCase(JQuarryReference.MOD_ID)){
            loadConfiguration();
        }
    }

    private static void loadConfiguration(){
        requireEnergy = configuration.getBoolean("requireEnergy", "Energy", true, "Quarries require energy");
        rfEnergy = configuration.getInt("rfEnergy", "Energy", 20, 0, 100, "Energy required PER BLOCK MINED");
        maxEnergyStored = configuration.getInt("maxEnergyStored", "Energy", 500000, 5000, 1000000, "Max energy stored in quarries");

        dirtQuarry = configuration.getString("dirtQuarry", "Recipes", Block.blockRegistry.getNameForObject(Blocks.dirt), "Block to make the Dirt Quarry");
        gravelQuarry = configuration.getString("gravelQuarry", "Recipes", Block.blockRegistry.getNameForObject(Blocks.gravel), "Block to make the Gravel Quarry");
        sandQuarry = configuration.getString("sandQuarry", "Recipes", Block.blockRegistry.getNameForObject(Blocks.sand), "Block to make the Sand Quarry");
        stoneQuarry = configuration.getString("stoneQuarry", "Recipes", Block.blockRegistry.getNameForObject(Blocks.stone), "Block to make the Stone Quarry");


        if(configuration.hasChanged()){
            configuration.save();
        }
    }
}
