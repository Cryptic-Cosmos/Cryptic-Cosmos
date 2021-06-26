package com.crypticcosmos.crypticcosmos.command;

import com.crypticcosmos.crypticcosmos.block.RiftBlock;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;

import static net.minecraft.command.Commands.argument;
import static net.minecraft.command.Commands.literal;
import static org.apache.commons.text.WordUtils.capitalizeFully;

public class RiftCommand {
    public static void register(@Nonnull CommandDispatcher<CommandSource> dispatcher) {
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

    public static int riftCommand(CommandContext<CommandSource> context, ServerPlayerEntity player) {
        ServerWorld destination = RiftBlock.rift(player.level, player, player.blockPosition());
        // gets the dimension's name
        final String destinationName = capitalizeFully(destination.dimension().location().getPath().replaceAll("_", " "), ' ', '_');

        context.getSource().sendSuccess(new TranslationTextComponent("commands.rift.success",
                        player.getDisplayName(),
                        destinationName),
                true);

        return 0;
    }
}

