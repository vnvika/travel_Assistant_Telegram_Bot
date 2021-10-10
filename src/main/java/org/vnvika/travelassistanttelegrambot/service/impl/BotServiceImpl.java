package org.vnvika.travelassistanttelegrambot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.vnvika.travelassistanttelegrambot.model.City;
import org.vnvika.travelassistanttelegrambot.model.Place;
import org.vnvika.travelassistanttelegrambot.repository.CityRepository;
import org.vnvika.travelassistanttelegrambot.repository.PlaceRepository;
import org.vnvika.travelassistanttelegrambot.service.BotService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.vnvika.travelassistanttelegrambot.service.Message.CITY_NOT_FOUND;
import static org.vnvika.travelassistanttelegrambot.service.Message.HELP;

@Service
@Slf4j
@RequiredArgsConstructor
public class BotServiceImpl implements BotService {
    private final CityRepository cityRepository;
    private final PlaceRepository placeRepository;


    @Override
    public void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("Help"));

        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    @Override
    public void setCommand(SendMessage sendMessage, String message) {
        switch (message) {
            case "Help":
            case "/help":
            case "/help@travelAssistanttbot": {
                sendMessage.setText(HELP);
                break;
            }
            default: {
                City city = cityRepository.findByNameCity(message);

                if (city == null) {
                    sendMessage.setText(CITY_NOT_FOUND);
                } else {
                    Set<Place> places = placeRepository.findAllByCity_Id(city.getId());
                    sendMessage.setText(concatString(places));
                }
                break;
            }
        }

    }

    public String concatString(Set<Place> places) {
        StringBuilder message = new StringBuilder();
        places.forEach(place -> {
            message.append(place.getNamePlace()+", ");
        });
        return message.toString();
    }
}
