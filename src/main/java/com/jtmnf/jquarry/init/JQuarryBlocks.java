package com.jtmnf.jquarry.init;

import com.jtmnf.jquarry.blocks.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class JQuarryBlocks {

    public static final InitBlocks dirtQuarry = new DirtQuarry();
    public static final InitBlocks gravelQuarry = new GravelQuarry();
    public static final InitBlocks sandQuarry = new SandQuarry();
    public static final InitBlocks stoneQuarry = new StoneQuarry();
    public static final InitBlocks coalQuarry = new CoalQuarry();
    public static final InitBlocks ironQuarry = new IronQuarry();
    public static final InitBlocks lapisQuarry = new LapisQuarry();
    public static final InitBlocks goldQuarry = new GoldQuarry();
    public static final InitBlocks redstoneQuarry = new RedstoneQuarry();
    public static final InitBlocks diamondQuarry = new DiamondQuarry();

    public static final InitBlocks netherQuarry = new NetherQuarry();
    public static final InitBlocks quartzQuarry = new QuartzQuarry();

    public static void initJQuarryBlocks(){
        GameRegistry.registerBlock(dirtQuarry, ToolTipBlocks.class,"dirtQuarry");
        GameRegistry.registerBlock(gravelQuarry, ToolTipBlocks.class, "gravelQuarry");
        GameRegistry.registerBlock(sandQuarry, ToolTipBlocks.class, "sandQuarry");
        GameRegistry.registerBlock(stoneQuarry, ToolTipBlocks.class, "stoneQuarry");
        GameRegistry.registerBlock(coalQuarry, ToolTipBlocks.class, "coalQuarry");
        GameRegistry.registerBlock(ironQuarry, ToolTipBlocks.class, "ironQuarry");
        GameRegistry.registerBlock(lapisQuarry, ToolTipBlocks.class, "lapisQuarry");
        GameRegistry.registerBlock(goldQuarry, ToolTipBlocks.class, "goldQuarry");
        GameRegistry.registerBlock(redstoneQuarry, ToolTipBlocks.class, "redstoneQuarry");
        GameRegistry.registerBlock(diamondQuarry, ToolTipBlocks.class, "diamondQuarry");

        GameRegistry.registerBlock(netherQuarry, ToolTipBlocks.class, "netherQuarry");
        GameRegistry.registerBlock(quartzQuarry, ToolTipBlocks.class, "quartzQuarry");
    }

    public static void initJQuarryDependencies(List<String> list){
        ArrayList<DependenciesQuarry> temp = new ArrayList<DependenciesQuarry>();

        for(int i = 0 ; i < list.size(); i += 4){
            if(i+2 < list.size()){
                String blockName = list.get(i+2);

                if(blockName != null){
                    if(Block.blockRegistry.getObject(list.get((i))) != Blocks.air){
                        temp.add(new DependenciesQuarry((Block) Block.blockRegistry.getObject(list.get(i)), Integer.parseInt(list.get(i+1)), blockName, list.get(i+3)));

                        GameRegistry.registerBlock(temp.get(temp.size()-1), ToolTipBlocks.class , "dependencyQuarry."+blockName);
                    }
                }
            }
        }

        for(int i = 0; i < temp.size(); ++i){
            GameRegistry.addShapedRecipe(new ItemStack(temp.get(i).getThis(), 1),
                    "BBB",
                    "CIC",
                    "WCW",
                    'B', new ItemStack(temp.get(i).getBlock(), 1, temp.get(i).getMetadata()),
                    'I', JQuarryBlocks.ironQuarry,
                    'C', Blocks.cobblestone,
                    'W', Blocks.planks
            );
        }
    }
}
