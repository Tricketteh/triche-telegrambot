package com.github.Tricketteh.ttb.command;

import com.github.Tricketteh.ttb.service.SendBotMessageService;
import com.github.Tricketteh.ttb.service.TelegramUserService;
import com.google.common.collect.ImmutableMap;

import static com.github.Tricketteh.ttb.command.CommandName.*;

 /*
 Container of the {@link Command}s, which are using for handling telegram commands.
 */

public class CommandContainer {

    private final ImmutableMap<String, command> commandMap;
    private final command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        commandMap = ImmutableMap.<String, command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService, telegramUserService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .put(STAT.getCommandName(), new StatCommand(sendBotMessageService, telegramUserService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);

    }

    public command retrieveCommand(String commandIdentifier){
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
