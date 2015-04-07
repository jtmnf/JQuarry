package com.jtmnf.jquarry.init;

import com.jtmnf.jquarry.tileentity.TileEntityQuarrys;
import cpw.mods.fml.common.registry.GameRegistry;

public class JQuarryTiles {

    public static void initJQuarryTiles(){
        GameRegistry.registerTileEntity(TileEntityQuarrys.class, "tileQuarrys");
    }

}
