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

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

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
        DefaultDispenseItemBehavior dispenserBehavior = new DefaultDispenseItemBehavior() {
            @Override
            public ItemStack execute(IBlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
                EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());

                type.spawn(
                        source.getLevel(),
                        stack,
                        null,
                        source.getPos().relative(direction),
                        SpawnReason.DISPENSER,
                        direction != Direction.UP,
                        false
                );
                stack.shrink(1);

                return stack;
            }
        };

        UNADDED_EGGS.forEach(spawnEgg -> {
            BY_ID.put(spawnEgg.getType(null), spawnEgg);
            DispenserBlock.registerBehavior(spawnEgg, dispenserBehavior);
        });

        UNADDED_EGGS.clear();
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundNBT nbt) {
        return this.entityTypeSupplier.get();
    }
}
