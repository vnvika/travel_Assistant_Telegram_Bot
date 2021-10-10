package org.vnvika.travelassistanttelegrambot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.vnvika.travelassistanttelegrambot.config.BotConfig;

@Component
@Slf4j
@RequiredArgsConstructor
public class Bot extends TelegramLongPollingBot {
    private final BotConfig botConfig;
    private final BotService botService;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage sendMessage = new SendMessage();

            String message = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();

            sendMessage.setChatId(chatId);
            botService.setButtons(sendMessage);
            botService.setCommand(sendMessage, message);

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                //TODO add log
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

}
