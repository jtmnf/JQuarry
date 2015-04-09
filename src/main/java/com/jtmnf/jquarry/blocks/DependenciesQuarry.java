package com.jtmnf.jquarry.blocks;

import com.jtmnf.jquarry.modload.TextureBlocks;
import com.jtmnf.jquarry.tileentity.TileEntityQuarrys;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import javafx.scene.effect.ImageInput;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.Drawable;
import sun.net.ResourceManager;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class DependenciesQuarry extends InitBlocks{
    @SideOnly(Side.CLIENT)
    private IIcon side;

    @SideOnly(Side.CLIENT)
    private IIcon front;

    public int metadata;
    public String textureNameOre;
    public Block block;

    public DependenciesQuarry(Block block, int metadata, String uniqueName, String textureNameOre){
        super(Material.rock, block);

        this.setBlockName("dependencyQuarry."+uniqueName);
        this.metadata = metadata;
        this.textureNameOre = textureNameOre;
        this.block = block;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister reg) {
        this.side = reg.registerIcon("jquarry:side");
        this.front = reg.registerIcon("jquarry:front");
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
        return new TileEntityQuarrys(this.metadata);
    }

    public Block getThis(){
        return this;
    }

    public Block getBlock() {
        return block;
    }

    public int getMetadata() {
        return metadata;
    }
}
