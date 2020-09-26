package com.hauntedchest.LovecraftPlus.Items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class MysteriousAmulet extends Item {
    public MysteriousAmulet(Properties properties) {
        super(properties);
    }
    boolean potion = false;

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity player, Hand handIn) {
        return super.onItemRightClick(worldIn, player, handIn);
    }
}
