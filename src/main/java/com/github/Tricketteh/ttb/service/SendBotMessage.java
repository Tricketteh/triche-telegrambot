package com.github.Tricketteh.ttb.service;

import com.github.Tricketteh.ttb.bot.TricheTgBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessage implements SendBotMessageService{

    private final TricheTgBot tricheTgBot;

    @Autowired
    public SendBotMessage(TricheTgBot tricheTgBot){
        this.tricheTgBot = tricheTgBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sm = new SendMessage();
        sm.setChatId(chatId);
        sm.enableHtml(true);
        sm.setText(message);

        try {
            tricheTgBot.execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
