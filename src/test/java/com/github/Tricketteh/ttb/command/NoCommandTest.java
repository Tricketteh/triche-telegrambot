package com.github.Tricketteh.ttb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.Tricketteh.ttb.command.CommandName.NO;
import static com.github.Tricketteh.ttb.command.NoCommand.NO_MESSAGE;


@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}
