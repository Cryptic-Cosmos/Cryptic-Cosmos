package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.commands.RiftCommand;
import net.minecraftforge.event.RegisterCommandsEvent;

public class CommandRegistries {
    @SuppressWarnings("unused")
    public static void registerCommands(RegisterCommandsEvent event) {
        RiftCommand.register(event.getDispatcher());
    }
}