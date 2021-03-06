package com.github.Tricketteh.ttb.command;

import static com.github.Tricketteh.ttb.command.CommandName.STAT;
import static com.github.Tricketteh.ttb.command.StatCommand.STAT_MESSAGE;

public class StatCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(STAT_MESSAGE, 0);
    }

    @Override
    command getCommand() {
        return new StatCommand(sendBotMessageService, telegramUserService);
    }
}
