package com.github.Tricketteh.ttb.bot;

import com.github.Tricketteh.ttb.command.CommandContainer;
import com.github.Tricketteh.ttb.service.SendBotMessage;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


import static com.github.Tricketteh.ttb.command.CommandName.NO;

/* Triche's Telegram Bot written in Java.
*/

@Component
public class TricheTgBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    public TricheTgBot(){
        this.commandContainer = new CommandContainer(new SendBotMessage(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {

        return username;
    }

    @Override
    public String getBotToken() {

        return token;
    }

}
