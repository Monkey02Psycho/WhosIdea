package org.yacks.items;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

public class SolidifiedFire extends Item {

    // this gets a list of all messages from the lang file
    private String[] messages = { I18n.format("messages.whosidea.solid_fire.1"),
            I18n.format("messages.whosidea.solid_fire.2"), I18n.format("messages.whosidea.solid_fire.3"),
            I18n.format("messages.whosidea.solid_fire.4"), I18n.format("messages.whosidea.solid_fire.5") };

    // Random instance for random messages
    Random random = new Random();

    public SolidifiedFire() {
        super(new Item.Properties().group(ItemGroup.MATERIALS).maxStackSize(4));

    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        // sets the entity that has it in inventory on fire for 15 ticks
        entityIn.setFire(15);
        /*
        if a randomly made number is 0 and the item is selected then It will put a random message in chat
        */
        if (isSelected && random.nextInt(100) == 0) {
            entityIn.sendMessage(ITextComponent.getTextComponentOrEmpty(random_message()), entityIn.getUniqueID());
        }

    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip,
            ITooltipFlag flagIn) {
        // this adds the description to the item.
        tooltip.add(ITextComponent.getTextComponentOrEmpty(I18n.format("desc.whosidea.solid_fire")));
    }

    /**
     * 
     * @return any random from the messages variable
     */
    private String random_message() {
        return messages[random.nextInt(messages.length)];
    }
}
