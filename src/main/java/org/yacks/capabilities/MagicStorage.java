package org.yacks.capabilities;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
/**
 * This implements the storage for IMagic. Thats all the class does
 * @see net.minecraftforge.common.capabilities.Capability.IStorage
 */
public class MagicStorage implements IStorage<IMagic> {

    @Override
    public INBT writeNBT(Capability<IMagic> capability, IMagic instance, Direction side) {
        return IntNBT.valueOf(instance.getMagic());
    }

    @Override
    public void readNBT(Capability<IMagic> capability, IMagic instance, Direction side, INBT nbt) {
        instance.setMagic(((IntNBT)nbt).getInt());
    }

}
