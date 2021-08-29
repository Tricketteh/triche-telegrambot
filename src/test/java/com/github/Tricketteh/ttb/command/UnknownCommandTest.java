package com.github.Tricketteh.ttb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.Tricketteh.ttb.command.UnknownCommand.UNKNOWN_MESSAGE;

@DisplayName("Unit-level testing for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return "/fdgdfgdfgdbd";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
