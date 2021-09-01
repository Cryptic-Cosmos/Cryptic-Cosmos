package com.crypticcosmos.crypticcosmos.effect;

import com.crypticcosmos.crypticcosmos.entity.creature.gromble_frog.GrombleFrog;
import com.crypticcosmos.crypticcosmos.register.EntityTypeRegistries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import javax.annotation.Nonnull;

public class CorruptionEffect extends MobEffect {
    public static final DamageSource CORRUPTION_DAMAGE_SOURCE = new DamageSource("corruption")
            .setMagic()
            .bypassArmor();

    public CorruptionEffect() {
        super(MobEffectCategory.HARMFUL, 0x584033);
    }

    @Override
    public void applyEffectTick(@Nonnull LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
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

                GrombleFrog grombleFrog = new GrombleFrog(EntityTypeRegistries.GROMBLE_FROG.get(), event.getEntity().level);
                grombleFrog.moveTo(killedEntity.blockPosition(),
                        killedEntity.getYRot(),
                        killedEntity.getXRot());

                //noinspection ConstantConditions
                grombleFrog.finalizeSpawn(killedEntity.getServer().overworld(),
                        killedEntity.level.getCurrentDifficultyAt(grombleFrog.blockPosition()),
                        MobSpawnType.MOB_SUMMONED,
                        null,
                        null);
            }
        }
    }
}
