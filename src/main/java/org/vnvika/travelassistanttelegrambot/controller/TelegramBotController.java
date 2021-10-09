package org.vnvika.travelassistanttelegrambot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vnvika.travelassistanttelegrambot.service.Bot;

@RestController
@RequiredArgsConstructor
public class TelegramBotController {
    private final Bot bot;

}
