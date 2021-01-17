package com.crypticcosmos.crypticcosmos.items;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("NullableProblems")
public class CustomSpawnEggItem extends SpawnEggItem {
    private static final List<CustomSpawnEggItem> UNADDED_EGGS = new ArrayList<>();
    private final Lazy<? extends EntityType<?>> entityTypeSupplier;

    public CustomSpawnEggItem(
            final NonNullSupplier<? extends EntityType<?>> entityTypeSupplier,
            int primaryColorIn,
            int secondaryColorIn,
            Properties builder
    ) {
        //noinspection ConstantConditions
        super(null, primaryColorIn, secondaryColorIn, builder);

        this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
        UNADDED_EGGS.add(this);
    }

    public static void initSpawnEggs() {
        final Map<EntityType<?>, SpawnEggItem> EGGS = Objects.requireNonNull(
                ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b")
        );

        DefaultDispenseItemBehavior dispenserBehavior = new DefaultDispenseItemBehavior() {
            @Override
            protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().get(DispenserBlock.FACING);
                EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());

                type.spawn(
                        source.getWorld(),
                        stack,
                        null,
                        source.getBlockPos().offset(direction),
                        SpawnReason.DISPENSER,
                        direction != Direction.UP,
                        false
                );
                stack.shrink(1);

                return stack;
            }
        };

        for (SpawnEggItem spawnEgg : UNADDED_EGGS) {
            EGGS.put(spawnEgg.getType(null), spawnEgg);
            DispenserBlock.registerDispenseBehavior(spawnEgg, dispenserBehavior);
        }

        UNADDED_EGGS.clear();
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundNBT nbt) {
        return this.entityTypeSupplier.get();
    }
}
