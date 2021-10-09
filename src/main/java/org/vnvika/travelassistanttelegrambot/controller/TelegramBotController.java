package org.vnvika.travelassistanttelegrambot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.vnvika.travelassistanttelegrambot.dto.CityDto;
import org.vnvika.travelassistanttelegrambot.mapper.CityMapper;
import org.vnvika.travelassistanttelegrambot.model.City;
import org.vnvika.travelassistanttelegrambot.service.CityService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class TelegramBotController {
    private final CityService cityService;

    @PostMapping("/city")
    public ResponseEntity<CityDto> save(@Valid @RequestBody CityDto cityDto) {
        City city = cityService.save(cityDto);
        return ResponseEntity.ok(CityMapper.INSTANCE.toDTO(city));
    }

}
