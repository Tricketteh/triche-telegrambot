package com.github.Tricketteh.ttb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.Tricketteh.ttb.command.CommandName.STOP;
import static com.github.Tricketteh.ttb.command.StopCommand.STOP_MESSAGE;

@DisplayName("Unit-level testing for StopCommand")
public class StopCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}
