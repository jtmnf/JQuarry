package com.jtmnf.jquarry.init;

import com.jtmnf.jquarry.handler.JQuarryConfiguration;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class JQuarryRecipes {
    public static void initRecipes(){

        /* TODO: BLOCKS RECIPES */
        GameRegistry.addShapedRecipe(new ItemStack(JQuarryBlocks.dirtQuarry, 1),
                "DDD",
                "CDC",
                "WCW",
                'D', Block.blockRegistry.getObject(JQuarryConfiguration.dirtQuarry),
                'G', Blocks.glass,
                'C', Blocks.cobblestone,
                'W', Blocks.planks
        );

        GameRegistry.addShapedRecipe(new ItemStack(JQuarryBlocks.gravelQuarry, 1),
                "GGG",
                "CFC",
                "WCW",
                'G', Block.blockRegistry.getObject(JQuarryConfiguration.gravelQuarry),
                'C', Blocks.cobblestone,
                'F', Items.flint,
                'W', Blocks.planks
        );

        GameRegistry.addShapedRecipe(new ItemStack(JQuarryBlocks.sandQuarry, 1),
                "SSS",
                "CJC",
                "WCW",
                'S', Block.blockRegistry.getObject(JQuarryConfiguration.sandQuarry),
                'C', Blocks.cobblestone,
                'J', JQuarryBlocks.dirtQuarry,
                'W', Blocks.planks
        );

        GameRegistry.addShapedRecipe(new ItemStack(JQuarryBlocks.stoneQuarry, 1),
                "SSS",
                "CJC",
                "WCW",
                'S', Block.blockRegistry.getObject(JQuarryConfiguration.stoneQuarry),
                'C', Blocks.cobblestone,
                'J', JQuarryBlocks.dirtQuarry,
                'W', Blocks.planks
        );

        GameRegistry.addShapedRecipe(new ItemStack(JQuarryBlocks.coalQuarry, 1),
                "CCC",
                "SJS",
                "WSW",
                'S', Blocks.cobblestone,
                'C', Items.coal,
                'J', JQuarryBlocks.stoneQuarry,
                'W', Blocks.planks
        );

        GameRegistry.addShapedRecipe(new ItemStack(JQuarryBlocks.ironQuarry, 1),
                "III",
                "SJS",
                "WSW",
                'S', Blocks.cobblestone,
                'I', Items.iron_ingot,
                'J', JQuarryBlocks.stoneQuarry,
                'W', Blocks.planks
        );

        GameRegistry.addShapedRecipe(new ItemStack(JQuarryBlocks.lapisQuarry, 1),
                "LLL",
                "SJS",
                "WSW",
                'S', Blocks.cobblestone,
                'L', new ItemStack(Items.dye, 1, 4),
                'J', JQuarryBlocks.stoneQuarry,
                'W', Blocks.planks
        );

        GameRegistry.addShapedRecipe(new ItemStack(JQuarryBlocks.goldQuarry, 1),
                "GGG",
                "SJS",
                "WSW",
                'S', Blocks.cobblestone,
                'G', Items.gold_ingot,
                'J', JQuarryBlocks.ironQuarry,
                'W', Blocks.planks
        );

        GameRegistry.addShapedRecipe(new ItemStack(JQuarryBlocks.redstoneQuarry, 1),
                "RRR",
                "SJS",
                "WSW",
                'S', Blocks.cobblestone,
                'R', Items.redstone,
                'J', JQuarryBlocks.ironQuarry,
                'W', Blocks.planks
        );

        GameRegistry.addShapedRecipe(new ItemStack(JQuarryBlocks.diamondQuarry, 1),
                "DDD",
                "SJS",
                "WSW",
                'S', Blocks.cobblestone,
                'D', Items.diamond,
                'J', JQuarryBlocks.goldQuarry,
                'W', Blocks.planks
        );

        GameRegistry.addShapedRecipe(new ItemStack(JQuarryBlocks.netherQuarry, 1),
                "NNN",
                "SBS",
                "WSW",
                'S', Blocks.cobblestone,
                'N', Blocks.netherrack,
                'B', Items.netherbrick,
                'W', Blocks.planks
        );

        GameRegistry.addShapedRecipe(new ItemStack(JQuarryBlocks.quartzQuarry, 1),
                "QQQ",
                "SJS",
                "WSW",
                'S', Blocks.cobblestone,
                'Q', Items.quartz,
                'J', JQuarryBlocks.netherQuarry,
                'W', Blocks.planks
        );

        /* TODO: ITEMS RECIPES */
        GameRegistry.addShapedRecipe(new ItemStack(JQuarryItems.upgradeQuarry, 1),
                "RGR",
                "GIG",
                "RGR",
                'R', Items.redstone,
                'I', Items.iron_ingot,
                'G', Blocks.glass
        );

    }
}
