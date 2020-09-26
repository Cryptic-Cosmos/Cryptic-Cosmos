package com.hauntedchest.LovecraftPlus.Blocks;

import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(LovecraftPlusMod.BLOCKTAB));
    }
}
