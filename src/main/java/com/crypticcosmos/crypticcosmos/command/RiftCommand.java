package com.crypticcosmos.crypticcosmos.command;

import com.crypticcosmos.crypticcosmos.block.RiftBlock;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;

import javax.annotation.Nonnull;

import static net.minecraft.commands.Commands.argument;
import static net.minecraft.commands.Commands.literal;
import static org.apache.commons.text.WordUtils.capitalizeFully;

public class RiftCommand {
    public static void register(@Nonnull CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(literal("rift")
                .requires((commandSource) -> commandSource.hasPermission(2))
                // handles command if no player specified
                .executes(context -> riftCommand(context, context.getSource().getPlayerOrException()))
                .then(argument("target", EntityArgument.player())
                        // handles command if player specified
                        .executes(context -> riftCommand(context, EntityArgument.getPlayer(context, "target")))
                )
        );
    }

    public static int riftCommand(CommandContext<CommandSourceStack> context, ServerPlayer player) {
        var destination = RiftBlock.rift(player.level, player, player.blockPosition());
        // gets the dimension's name
        final String destinationName = capitalizeFully(destination.dimension().location().getPath().replaceAll("_", " "), ' ', '_');

        context.getSource().sendSuccess(new TranslatableComponent("commands.rift.success",
                        player.getDisplayName(),
                        destinationName),
                true);

        return 0;
    }
}

