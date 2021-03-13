package com.crypticcosmos.crypticcosmos.commands;

import com.crypticcosmos.crypticcosmos.blocks.RiftBlock;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.Entity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class RiftCommand implements Command<CommandSource> {
    private static final RiftCommand INSTANCE = new RiftCommand();

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("rift")
                .then(Commands.argument("target", EntityArgument.entity())
                        .executes(INSTANCE)));
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        final Entity entity = EntityArgument.getEntity(context, "target");

        RegistryKey<World> destination = RiftBlock.rift(entity.level, entity, entity.blockPosition());

        context.getSource().sendSuccess(
                new TranslationTextComponent(
                        "commands.rift.success",
                        entity.getDisplayName(),
                        destination.getRegistryName()),
                true);

        return 0;
    }
}

