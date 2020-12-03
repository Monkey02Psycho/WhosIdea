package org.yacks.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
/**
 * A block when a player collides with it will heal 2 hearts
 */
public class LifeBlock extends Block {

    public LifeBlock() {
        super(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(50.0f).harvestLevel(2)
                .harvestTool(ToolType.PICKAXE).setRequiresTool());
    }

    /**
     * checks if entity is player, if so heal 2 hearts
     */
    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof PlayerEntity) {
            // healing 4 because 1 is actually half a heart
            ((LivingEntity) entityIn).heal(4);
        }
    }

}
