package com.jtmnf.jquarry.tileentity;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import com.jtmnf.jquarry.handler.JQuarryConfiguration;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.IFluidHandler;

public class TileEntityQuarrys extends TileEntity implements IEnergyHandler {
    public int metadata;

    public TileEntityQuarrys(int metadata){
        this.metadata = metadata;
    }

    public TileEntityQuarrys(){
        this.metadata = 0;
    }

    public final EnergyStorage energyStorage = new EnergyStorage(JQuarryConfiguration.maxEnergyStored);

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        energyStorage.readFromNBT(tagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        tagCompound.setInteger("metadata", metadata);
        energyStorage.writeToNBT(tagCompound);
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        /* TODO */
    }

    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        return energyStorage.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored(ForgeDirection from) {
        return energyStorage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return energyStorage.getMaxEnergyStored();
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return true;
    }
}
