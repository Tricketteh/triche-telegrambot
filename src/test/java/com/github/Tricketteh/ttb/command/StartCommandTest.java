package com.github.Tricketteh.ttb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.Tricketteh.ttb.command.CommandName.START;
import static com.github.Tricketteh.ttb.command.StartCommand.START_MESSAGE;

@DisplayName("Unit-level testing for StartCommand")
public class StartCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}
