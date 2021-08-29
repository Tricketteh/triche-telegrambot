package com.github.Tricketteh.ttb.command;

import com.github.Tricketteh.ttb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

  /*
  Stop {@link Command}.
  */

public class StopCommand implements command{

    private final SendBotMessageService sendBotMessageService;
    public static final String STOP_MESSAGE = "I'm done";

    public StopCommand(SendBotMessageService sendBotMessageService){
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
