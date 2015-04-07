package com.jtmnf.jquarry.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class UpgradeQuarry extends InitItems {
    public UpgradeQuarry(){
        super();
        this.setBaseName("upgradeQuarry");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("jquarry:enlarge");
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean p_77624_4_) {
        list.add("\u00a74\u00a7nRight-click\u00a7r\u00a77 on a quarry to enlarge area");
        list.add("It can stack up to "+itemStack.getMaxStackSize());
    }
}
