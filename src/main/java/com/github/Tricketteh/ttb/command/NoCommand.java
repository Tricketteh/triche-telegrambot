package com.github.Tricketteh.ttb.command;

import com.github.Tricketteh.ttb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

  /*
  No {@link Command}.
  */

public class NoCommand implements command{

    private final SendBotMessageService sendBotMessageService;

    static final String NO_MESSAGE = "I can only understand /command_name.\n"
            + "If you want to see all available commands, type /help";

    public NoCommand(SendBotMessageService sendBotMessageService){
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
