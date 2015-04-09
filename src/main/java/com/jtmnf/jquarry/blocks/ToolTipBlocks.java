package com.jtmnf.jquarry.blocks;

import com.jtmnf.jquarry.JQuarry;
import com.jtmnf.jquarry.init.JQuarryBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ToolTipBlocks extends ItemBlock{
    InitBlocks block;

    public ToolTipBlocks(Block block) {
        super(block);
        this.block = (InitBlocks) block;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean p_77624_4_) {
        list.add("\u00a74\u00a7nChest over\u00a77\u00a7r the quarry");
        list.add("\u00a77\u00a7nRight-click\u00a77\u00a7r to run");
    }
}
