package com.jtmnf.jquarry.blocks;

import com.jtmnf.jquarry.tileentity.TileEntityQuarrys;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class GoldQuarry extends InitBlocks {
    @SideOnly(Side.CLIENT)
    private IIcon side;

    @SideOnly(Side.CLIENT)
    private IIcon front;

    public GoldQuarry(){
        super(Material.rock, Blocks.gold_ore);
        this.setBlockName("goldQuarry");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister reg) {
        this.side = reg.registerIcon("jquarry:side");
        this.front = reg.registerIcon("jquarry:frontGold");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata){
        if (side == 1) return this.side;
        else if (side == 0) return this.side;
        else if (metadata == 2 && side == 2) return this.front;
        else if (metadata == 3 && side == 5) return this.front;
        else if (metadata == 0 && side == 3) return this.front;
        else if (metadata == 1 && side == 4) return this.front;
        else return this.side;
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileEntityQuarrys(0);
    }
}
