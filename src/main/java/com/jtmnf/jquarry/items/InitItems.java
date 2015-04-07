package com.jtmnf.jquarry.items;

import com.jtmnf.jquarry.creativetab.CreativeTabJQuarry;
import com.jtmnf.jquarry.reference.JQuarryReference;
import net.minecraft.item.Item;

public class InitItems extends Item {
    public InitItems(){
        super();
        this.setMaxStackSize(8);
        this.setCreativeTab(CreativeTabJQuarry.JQuarryTab);
    }

    protected void setBaseName(String name) {
        setUnlocalizedName(JQuarryReference.MOD_ID.toLowerCase() + ":" + name);
        setTextureName(JQuarryReference.MOD_ID.toLowerCase() + ":" + name);
    }
}