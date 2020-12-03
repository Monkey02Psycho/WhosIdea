package org.yacks.items;

import java.util.List;

import javax.annotation.Nullable;

import org.yacks.materials.ModItemMaterials;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;

public class SharpSoft extends SwordItem {
    /**
     * A sword that does lots of damage
     * @see org.yacks.materials.ModItemMaterials
     */
    public SharpSoft() {
        super(ModItemMaterials.SHARP_SOFT, 10, 25f, new Item.Properties().group(ItemGroup.COMBAT));

    }

    /**
     * adds a counter to the item that counts the total number of entities it has hit.
     * It also decreses the items damage by 1
     */
    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        CompoundNBT nbt;

        nbt = stack.getOrCreateTag();

        if (nbt.contains("hits")) {
            nbt.putInt("hits", nbt.getInt("hits") + 1);

        } else {
            nbt.putInt("hits", 1);
        }

        stack.damageItem(1, attacker, (entity) -> {
            entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    /**
     * Adds lore to the item that tells the total damage done
     */
    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {  
        CompoundNBT nbt = stack.getOrCreateTag();
        // sets total hits to zero by default
        tooltip.add(ITextComponent.getTextComponentOrEmpty("Total hits: " + 0));
        // overrides if it has the nbt of hits
        if (nbt.contains("hits")){
            tooltip.set(1, ITextComponent.getTextComponentOrEmpty("Total hits: " + nbt.getInt("hits")));
        }
    }

}
