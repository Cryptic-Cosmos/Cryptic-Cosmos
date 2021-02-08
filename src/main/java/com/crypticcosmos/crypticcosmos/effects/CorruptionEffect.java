package com.crypticcosmos.crypticcosmos.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

import javax.annotation.Nonnull;

public class CorruptionEffect extends Effect {
    public CorruptionEffect() {
        super(EffectType.HARMFUL, 0x584033);

    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        this.addAttributesModifier(SharedMonsterAttributes.MOVEMENT_SPEED,
                "7107DE5E-7CE8-4030-940E-514C1F160890",
                amplifier * -0.3,
                AttributeModifier.Operation.MULTIPLY_TOTAL
        );

        // Item activeItem = entity.getActiveItemStack().getItem();
        //
        // if (activeItem instanceof ToolItem) {
        //     ToolItem tool = (ToolItem) activeItem;
        //
        //     if (tool.getTier().equals(ItemTier.WOOD)) {
        //         this.addAttributesModifier(SharedMonsterAttributes.ATTACK_SPEED,
        //                 "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3",
        //                 amplifier * 0.3,
        //                 AttributeModifier.Operation.MULTIPLY_TOTAL
        //         );
        //     } else {
        //         this.addAttributesModifier(SharedMonsterAttributes.ATTACK_SPEED,
        //                 "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3",
        //                 amplifier * -0.3,
        //                 AttributeModifier.Operation.MULTIPLY_TOTAL
        //         );
        //     }
        // }
    }

    /**
     * returns the name of the potion
     */
    @Nonnull
    @Override
    public String getName() {
        return "Corruption";
    }
}
