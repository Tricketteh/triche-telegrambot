package com.github.Tricketteh.ttb.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface command {

    void execute(Update update);

}
