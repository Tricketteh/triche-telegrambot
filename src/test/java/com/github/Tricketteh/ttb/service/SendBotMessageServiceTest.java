package com.github.Tricketteh.ttb.service;

import com.github.Tricketteh.ttb.bot.TricheTgBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private TricheTgBot tricheTgBot;

    @BeforeEach
    public void init(){
        tricheTgBot = Mockito.mock(TricheTgBot.class);
        sendBotMessageService = new SendBotMessage(tricheTgBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException{
        //given
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sm = new SendMessage();
        sm.setText(message);
        sm.setChatId(chatId);
        sm.enableHtml(true);

        //when
        sendBotMessageService.sendMessage(chatId,message);

        //then
        Mockito.verify(tricheTgBot).execute(sm);
    }
}
