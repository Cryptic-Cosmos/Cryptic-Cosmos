package com.crypticcosmos.crypticcosmos.item;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.register.EffectRegistries;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

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
    public ItemStack finishUsingItem(@Nonnull ItemStack stack, @Nonnull Level world, @Nonnull LivingEntity entity) {
        // removes the effect
        if (!world.isClientSide) entity.removeEffect(EffectRegistries.CORRUPTION.get());

        if (entity instanceof ServerPlayer serverPlayer) {
            // Triggers advancement criteria
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            // Awards the use stat.
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (entity instanceof Player player && !player.getAbilities().instabuild) {
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
    public UseAnim getUseAnimation(@Nonnull ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(@Nonnull Level world, @Nonnull Player player, @Nonnull InteractionHand hand) {
        return ItemUtils.startUsingInstantly(world, player, hand);
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack,
                                @Nullable Level world,
                                @Nonnull List<Component> components,
                                @Nonnull TooltipFlag tooltipFlag) {
        components.add(new TranslatableComponent(
                String.format("tooltip.%s.potion_of_purification", CrypticCosmos.MOD_ID)
        ));
    }

    @Override
    public boolean isFoil(@Nonnull ItemStack stack) {
        return true;
    }
}
