package org.vnvika.travelassistanttelegrambot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface BotService {
    void setButtons(SendMessage sendMessage);
    void setCommand(SendMessage sendMessage, String message);
}
