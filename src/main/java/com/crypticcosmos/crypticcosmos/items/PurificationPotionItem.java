package com.crypticcosmos.crypticcosmos.items;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.registries.EffectRegistries;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class PurificationPotionItem extends Item {
    public PurificationPotionItem() {
        super(new Properties()
                .craftRemainder(Items.GLASS_BOTTLE)
                .stacksTo(1)
                .tab(CrypticCosmos.CRYPTIC_COSMOS_ITEM_GROUP)
        );
    }

    @Nonnull
    @Override
    public ItemStack finishUsingItem(@Nonnull ItemStack stack, @Nonnull World world, @Nonnull LivingEntity entity) {
        // removes the effect
        if (!world.isClientSide) entity.removeEffect(EffectRegistries.CORRUPTION.get());

        if (entity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) entity;
            // Triggers advancement criteria
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            // Awards the use stat.
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (entity instanceof PlayerEntity && !((PlayerEntity) entity).abilities.instabuild) {
            // Removes the item itself.
            stack.shrink(1);
        }

        // sets the stack to a glass bottle if consumed.
        return stack.isEmpty() ? new ItemStack(Items.GLASS_BOTTLE) : stack;
    }

    @Override
    public int getUseDuration(@Nonnull ItemStack stack) {
        return 32;
    }

    @Nonnull
    @Override
    public UseAction getUseAnimation(@Nonnull ItemStack stack) {
        return UseAction.DRINK;
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> use(@Nonnull World world, @Nonnull PlayerEntity player, @Nonnull Hand hand) {
        return DrinkHelper.useDrink(world, player, hand);
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack,
                                @Nullable World world,
                                @Nonnull List<ITextComponent> components,
                                @Nonnull ITooltipFlag tooltipFlag) {
        components.add(new TranslationTextComponent(
                String.format("tooltip.%s.potion_of_purification", CrypticCosmos.MOD_ID)
        ));
    }

    @Override
    public boolean isFoil(@Nonnull ItemStack stack) {
        return true;
    }
}
