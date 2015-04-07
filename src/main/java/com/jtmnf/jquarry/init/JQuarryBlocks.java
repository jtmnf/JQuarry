package com.jtmnf.jquarry.init;

import com.jtmnf.jquarry.blocks.*;
import cpw.mods.fml.common.registry.GameRegistry;

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
}
