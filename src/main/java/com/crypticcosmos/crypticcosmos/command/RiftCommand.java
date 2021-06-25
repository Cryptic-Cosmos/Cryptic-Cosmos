package com.crypticcosmos.crypticcosmos.command;

import com.crypticcosmos.crypticcosmos.block.RiftBlock;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.server.ServerWorld;

import static net.minecraft.command.Commands.argument;
import static net.minecraft.command.Commands.literal;
import static org.apache.commons.text.WordUtils.capitalizeFully;

public class RiftCommand implements Command<CommandSource> {
    private static final RiftCommand INSTANCE = new RiftCommand();

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(literal("rift")
                .requires((commandSource) -> commandSource.hasPermission(2))
                .then(argument("target", EntityArgument.player())
                        .executes(INSTANCE))
        );
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        final ServerPlayerEntity player = EntityArgument.getPlayer(context, "target");

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

