package com.jtmnf.jquarry.modload;

import java.io.*;
import java.util.List;

import com.google.gson.*;
import com.jtmnf.jquarry.blocks.InitBlocks;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GetModsDependencies {

    static class OreToAdd{
        private List<String> ores;

        public List<String> getOres() {
            return ores;
        }
    }

    public static List<String> initDependencies(File file, String filePath){
        Gson gson = new Gson();

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            OreToAdd oreToAdd = gson.fromJson(bufferedReader, OreToAdd.class);

            List<String> ores = oreToAdd.getOres();

            return ores;

        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
