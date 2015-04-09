package com.jtmnf.jquarry.creativetab;

import com.jtmnf.jquarry.init.JQuarryBlocks;
import com.jtmnf.jquarry.init.JQuarryItems;
import com.jtmnf.jquarry.reference.JQuarryReference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabJQuarry {
    public static final CreativeTabs JQuarryTab = new CreativeTabs(JQuarryReference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return JQuarryItems.upgradeQuarry;
        }
    };
}
