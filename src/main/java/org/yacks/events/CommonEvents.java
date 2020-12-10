package org.yacks.events;

import org.yacks.WhosIdea;
import org.yacks.capabilities.IMagic;
import org.yacks.capabilities.Magic;
import org.yacks.capabilities.MagicProvider;

import net.minecraft.util.text.TranslationTextComponent;

import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WhosIdea.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEvents {

    /**
     * gets players capability and adds 25 magic to them. also sends a message in chat with their magic
     * @param event the event when the player wakes up
     */
    @SubscribeEvent
    public static void addSleepMana(PlayerWakeUpEvent event){
        IMagic magic= event.getPlayer().getCapability(MagicProvider.MAGIC_CAPABILITY).orElse(new Magic());
        magic.fill(25);
        if(!event.getPlayer().world.isRemote){
            event.getPlayer().sendMessage(new TranslationTextComponent("Player now has: %s", magic.getMagic()), null);
        }
    }

}
