package com.github.Tricketteh.ttb.command;

import com.github.Tricketteh.ttb.service.SendBotMessageService;
import com.github.Tricketteh.ttb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

  /*
  Stop {@link Command}.
  */

public class StopCommand implements command{

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;
    public static final String STOP_MESSAGE = "I'm done";

    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
        telegramUserService.findByChatId(update.getMessage().getChatId().toString())
                .ifPresent(it -> {
                    it.setActive(false);
                    telegramUserService.save(it);
                });
    }
}
