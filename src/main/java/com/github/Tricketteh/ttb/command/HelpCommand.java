package com.github.Tricketteh.ttb.command;

import com.github.Tricketteh.ttb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.Tricketteh.ttb.command.CommandName.*;

 /*
 Help {@link Command}.
 */

public class HelpCommand implements command{

    private final SendBotMessageService sendBotMessageService;
    static final String HELP_MESSAGE = String.format("<b>Available commands:</b>\n\n"

                    + "<b>Start\\stop working with bot</b>\n"
                    + "%s - start working with me\n"
                    + "%s - stop working with me\n\n"
                    + "%s - get help\n"
                    + "%s - get stats\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName(), STAT.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService){
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
