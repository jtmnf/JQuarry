package com.jtmnf.jquarry.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ToolTipBlocks extends ItemBlock{
    public ToolTipBlocks(Block p_i45328_1_) {
        super(p_i45328_1_);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean p_77624_4_) {
        list.add("\u00a74\u00a7nChest over\u00a77\u00a7r the quarry");
        list.add("\u00a77\u00a7nRight-click\u00a77\u00a7r to run");
    }
}
