package com.github.Tricketteh.ttb.command;

import com.github.Tricketteh.ttb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

  /*
  Start {@link Command}.
  */

public class StartCommand implements command {

    private final SendBotMessageService sendBotMessageService;
    final static String START_MESSAGE = "Hello! I'm actually a super useless and shitty bot but you can use me";


    // We don't add service here by getting from Application Context.
    // Because if you do it like this, then there will be a cyclic dependency,
    // which breaks the application.
    public StartCommand(SendBotMessageService sendBotMessageService){
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
