package com.crypticcosmos.crypticcosmos.effect;

import com.crypticcosmos.crypticcosmos.entity.creature.gromble_frog.GrombleFrogEntity;
import com.crypticcosmos.crypticcosmos.register.EntityTypeRegistries;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import javax.annotation.Nonnull;

public class CorruptionEffect extends Effect {
    public static final DamageSource CORRUPTION_DAMAGE_SOURCE = new DamageSource("corruption")
            .setMagic()
            .bypassArmor();

    public CorruptionEffect() {
        super(EffectType.HARMFUL, 0x584033);
    }

    @Override
    public void applyEffectTick(@Nonnull LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            float exhaustionMultiplier = 2f;
            player.causeFoodExhaustion(exhaustionMultiplier * (float) (amplifier + 1));
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        int j = 25 >> amplifier;
        if (j > 0) return duration % j == 0;
        else return true;
    }

    /**
     * returns the name of the potion
     */
    @Nonnull
    @Override
    public String getDescriptionId() {
        return "Corruption";
    }

    public static class SpawnFrogOnCorruptionKill {
        public static void spawnFrogOnCorruptionKill(LivingDeathEvent event) {
            if (event.getSource().equals(CORRUPTION_DAMAGE_SOURCE)) {
                LivingEntity killedEntity = event.getEntityLiving();

                GrombleFrogEntity gorbleFrog = new GrombleFrogEntity(EntityTypeRegistries.GROMBLE_FROG.get(), event.getEntity().level);
                gorbleFrog.moveTo(killedEntity.blockPosition(),
                        killedEntity.yRot,
                        killedEntity.xRot);

                //noinspection ConstantConditions
                gorbleFrog.finalizeSpawn(killedEntity.getServer().overworld(),
                        killedEntity.level.getCurrentDifficultyAt(gorbleFrog.blockPosition()),
                        SpawnReason.MOB_SUMMONED,
                        null,
                        null);
            }
        }
    }
}
