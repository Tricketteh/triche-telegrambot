package com.github.Tricketteh.ttb.command;


import org.junit.jupiter.api.DisplayName;

import static com.github.Tricketteh.ttb.command.CommandName.HELP;
import static com.github.Tricketteh.ttb.command.HelpCommand.HELP_MESSAGE;

@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}
