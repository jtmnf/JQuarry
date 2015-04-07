package com.jtmnf.jquarry.init;

import com.jtmnf.jquarry.items.InitItems;
import com.jtmnf.jquarry.items.UpgradeQuarry;
import com.jtmnf.jquarry.reference.JQuarryReference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(JQuarryReference.MOD_ID)
public class JQuarryItems {
    public static final InitItems upgradeQuarry = new UpgradeQuarry();

    public static void initJQuarryItems(){
        GameRegistry.registerItem(upgradeQuarry, "upgradeQuarry");
    }
}
