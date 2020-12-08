package org.yacks.events;

import org.yacks.WhosIdea;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = WhosIdea.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void toolTipDescEvent(ItemTooltipEvent event) {
        Item item = event.getItemStack().getItem();
        String desc_key = item.getTranslationKey() + ".desc";
        if (I18n.hasKey(desc_key)) {
            event.getToolTip().add(new TranslationTextComponent(desc_key));
        }
    }
}
