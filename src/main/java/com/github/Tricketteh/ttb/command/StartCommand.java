package com.github.Tricketteh.ttb.command;

import com.github.Tricketteh.ttb.repository.entity.TelegramUser;
import com.github.Tricketteh.ttb.service.SendBotMessageService;
import com.github.Tricketteh.ttb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

  /*
  Start {@link Command}.
  */

public class StartCommand implements command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;
    final static String START_MESSAGE = "Hello! I'm actually a super useless and shitty bot but you can use me";


    // We don't add service here by getting from Application Context.
    // Because if you do it like this, then there will be a cyclic dependency,
    // which breaks the application.
    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(true);
                    telegramUserService.save(user);
                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setActive(true);
                    telegramUser.setChatId(chatId);
                    telegramUserService.save(telegramUser);
                });
        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
    }
}
