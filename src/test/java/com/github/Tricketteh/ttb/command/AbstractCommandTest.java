package com.github.Tricketteh.ttb.command;

import com.github.Tricketteh.ttb.bot.TricheTgBot;
import com.github.Tricketteh.ttb.service.SendBotMessageService;
import com.github.Tricketteh.ttb.service.SendBotMessage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.xml.sax.SAXNotRecognizedException;

/*
Abstract class for testing {@link Command}s.
*/
abstract class AbstractCommandTest {
    protected TricheTgBot tricheTgBot = Mockito.mock(TricheTgBot.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessage(tricheTgBot);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException{
        //given
        long chatId = 1234567824356L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        //when
        getCommand().execute(update);

        //then
        Mockito.verify(tricheTgBot).execute(sendMessage);
    }
}
