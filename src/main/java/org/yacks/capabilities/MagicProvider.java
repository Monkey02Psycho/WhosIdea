package org.yacks.capabilities;

import org.yacks.WhosIdea;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * This serializes the capability and allows us to save it.
 * Magic_CAPABILITY stores the actual capability and instance stores the defult
 * instance of the capability.
 */
public class MagicProvider implements ICapabilitySerializable<INBT> {

    @CapabilityInject(IMagic.class)
    public static final Capability<IMagic> MAGIC_CAPABILITY = null;

    private LazyOptional<IMagic> instance = LazyOptional.of(MAGIC_CAPABILITY::getDefaultInstance);

	/**
     * this checks to see if the capability is ours and if so returns it
     */
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == MAGIC_CAPABILITY ? instance.cast() : LazyOptional.empty(); 
    }

    @Override
    public INBT serializeNBT() {
        return MAGIC_CAPABILITY.getStorage().writeNBT(MAGIC_CAPABILITY, this.instance.orElse(new Magic()), null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        MAGIC_CAPABILITY.getStorage().readNBT(MAGIC_CAPABILITY, this.instance.orElse(new Magic()), null, nbt);

    }
    
    @Mod.EventBusSubscriber
    public static class MagicEvent{
        public static final ResourceLocation MANA_CAP = new ResourceLocation(WhosIdea.MOD_ID, "magic");
        /**
         * Attaches the magic capability to the player. now you can actally use it
         */
        @SubscribeEvent
        public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof PlayerEntity) {
                event.addCapability(MANA_CAP, new MagicProvider());
            }

        }
    }
    
}
