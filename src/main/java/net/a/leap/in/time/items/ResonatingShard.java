package net.a.leap.in.time.items;

import net.a.leap.in.time.ALeapinTime;
import net.a.leap.in.time.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;

public class ResonatingShard extends Item {
    public ResonatingShard() {
        super(new Item.Settings().group(ALeapinTime.ITEM_GROUP));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient && context.getWorld().getBlockState(context.getBlockPos()).equals(Blocks.STONE.getDefaultState()) && context.getWorld().isAir(context.getBlockPos().up())){
            context.getWorld().setBlockState(context.getBlockPos().up(), ModBlocks.RESONATING_CRYSTAL.getDefaultState());
            context.getStack().decrement(1);
            context.getWorld().playSound(null,context.getBlockPos(), SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS,1,1);
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }
}
