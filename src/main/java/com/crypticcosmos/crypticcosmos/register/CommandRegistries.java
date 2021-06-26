package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.command.RiftCommand;
import net.minecraftforge.event.RegisterCommandsEvent;

public class CommandRegistries {
    @SuppressWarnings("unused")
    public static void registerCommands(RegisterCommandsEvent event) {
        RiftCommand.register(event.getDispatcher());
    }
}