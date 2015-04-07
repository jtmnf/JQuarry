package com.jtmnf.jquarry.blocks;

import com.jtmnf.jquarry.creativetab.CreativeTabJQuarry;
import com.jtmnf.jquarry.handler.JQuarryConfiguration;
import com.jtmnf.jquarry.init.JQuarryItems;
import com.jtmnf.jquarry.reference.JQuarryReference;
import com.jtmnf.jquarry.tileentity.TileEntityQuarrys;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class InitBlocks extends Block {

    private Block blockToMine;

    public InitBlocks(Material material, Block block){
        super(material);

        this.blockToMine = block;

        this.setCreativeTab(CreativeTabJQuarry.JQuarryTab);
        this.setStepSound(Block.soundTypeMetal);
        this.setHardness(3F);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int whichDirectionFacing = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, whichDirectionFacing, 2);
    }

    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
        if(!world.isRemote){
            TileEntityQuarrys tileEntity = (TileEntityQuarrys) world.getTileEntity(x, y, z);
            player.addChatMessage(new ChatComponentText("[JQuarry] Energy: "+ tileEntity.energyStorage.getEnergyStored()));
        }

        super.onBlockClicked(world, x, y, z, player);
    }

    @Override
    public boolean onBlockActivated(World world, int xCoord, int yCoord, int zCoord, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_){
        super.onBlockActivated(world, xCoord, yCoord, zCoord, player, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);

        if(!world.isRemote){
            NBTTagCompound tagCompound = writeToNBT(xCoord, yCoord, zCoord, world.getBlock(xCoord, yCoord, zCoord));

            TileEntityQuarrys tileEntityBlock = (TileEntityQuarrys) world.getTileEntity(tagCompound.getInteger("xCoord"), tagCompound.getInteger("yCoord"), tagCompound.getInteger("zCoord"));

            int extraTerrain = 2;

            if(player.inventory.getCurrentItem() != null){
                if(player.inventory.getCurrentItem().getItem().equals(JQuarryItems.upgradeQuarry)){
                    extraTerrain += player.inventory.getCurrentItem().stackSize;

                    player.inventory.getCurrentItem().stackSize = 0;
                }
                else{
                    player.addChatMessage(new ChatComponentText("[JQuarry] Right click with empty hand or with upgrades!"));
                    return false;
                }
            }

            int blocksMined = 0;

            int iMin = tagCompound.getInteger("xCoord")-extraTerrain+1;
            int jMin = tagCompound.getInteger("zCoord")-extraTerrain+1;

            int iMax = tagCompound.getInteger("xCoord")+extraTerrain;
            int jMax = tagCompound.getInteger("zCoord")+extraTerrain;

            TileEntity tileEntity;
            IInventory iInventory;

            Block upBlock = world.getBlock(tagCompound.getInteger("xCoord"), tagCompound.getInteger("yCoord")+1, tagCompound.getInteger("zCoord"));

            if(upBlock != Blocks.air){
                tileEntity = world.getTileEntity(tagCompound.getInteger("xCoord"), tagCompound.getInteger("yCoord")+1, tagCompound.getInteger("zCoord"));
                iInventory = (IInventory)tileEntity;
            }
            else{
                player.addChatMessage(new ChatComponentText("[JQuarry] Add a block with inventory above the quarry!"));
                return false;
            }

            if(iInventory == null) {
                player.addChatMessage(new ChatComponentText("[JQuarry] Add a block with inventory above the quarry!"));
                return false;
            }

            if (tileEntityBlock.energyStorage.getEnergyStored() < 20) {
                player.addChatMessage(new ChatComponentText("[JQuarry] Not enought energy!"));
                return false;
            }

            boolean isFull;

            for(int i = iMin; i < iMax; ++i){
                for(int j = jMin; j < jMax; ++j){
                    for(int z = tagCompound.getInteger("yCoord"); z > 0; --z){
                        if(world.getBlock(i, z, j) ==  Block.blockRegistry.getObject(tagCompound.getString("block")) && (tileEntityBlock.energyStorage.getEnergyStored() >= JQuarryConfiguration.rfEnergy)){
                            EntityItem blockItem = new EntityItem(world, tagCompound.getInteger("xCoord"), tagCompound.getInteger("yCoord")+1, tagCompound.getInteger("zCoord"), new ItemStack(Block.getBlockFromName(tagCompound.getString("block"))));

                            isFull = true;
                            for(int ii = 0; ii < iInventory.getSizeInventory(); ++ii){
                                if(iInventory.getStackInSlot(ii) == null){
                                    iInventory.setInventorySlotContents(ii, blockItem.getEntityItem());
                                    ii = iInventory.getSizeInventory()+1;
                                    isFull = false;
                                }
                                else if(iInventory.getStackInSlot(ii).getUnlocalizedName().contains(Block.getBlockFromName(tagCompound.getString("block")).getUnlocalizedName()) && iInventory.getStackInSlot(ii).stackSize < 64){
                                    iInventory.getStackInSlot(ii).stackSize++;
                                    ii = iInventory.getSizeInventory()+1;
                                    isFull = false;
                                }
                            }

                            if(isFull){
                                player.addChatMessage(new ChatComponentText("[JQuarry] Quarry "+(extraTerrain+1)+"x"+(extraTerrain+1)+" not completed, mined "+blocksMined+" block(s)!"));
                                player.addChatMessage(new ChatComponentText("[JQuarry] Inventory of "+upBlock.getLocalizedName()+" is full!"));
                                return false;
                            }

                            tileEntityBlock.energyStorage.setEnergyStored(tileEntityBlock.energyStorage.getEnergyStored() - JQuarryConfiguration.rfEnergy);

                            blocksMined++;

                            world.setBlock(i, z, j, Blocks.air);
                        }
                        else if(tileEntityBlock.energyStorage.getEnergyStored() <= 0 ){
                            player.addChatMessage(new ChatComponentText("[JQuarry] Not enought energy to finish the quarry!"));
                            return false;
                        }
                    }
                }
            }
            player.addChatMessage(new ChatComponentText("[JQuarry] Quarry "+(extraTerrain+1)+"x"+(extraTerrain+1)+" completed, mined "+blocksMined+" block(s)!"));
        }
        return true;
    }

    public NBTTagCompound writeToNBT(int x, int y, int z, Block block){
        ItemStack itemStack = new ItemStack(block);

        if(itemStack.getTagCompound() == null){
            itemStack.setTagCompound(new NBTTagCompound());
            itemStack.getTagCompound().setInteger("xCoord", x);
            itemStack.getTagCompound().setInteger("yCoord", y);
            itemStack.getTagCompound().setInteger("zCoord", z);
            itemStack.getTagCompound().setString("block", Block.blockRegistry.getNameForObject(blockToMine));
            return itemStack.getTagCompound();
        }
        else{
            return itemStack.getTagCompound();
        }
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", JQuarryReference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName){
        return unlocalizedName.substring(unlocalizedName.toLowerCase().indexOf(".")+1);
    }
}
