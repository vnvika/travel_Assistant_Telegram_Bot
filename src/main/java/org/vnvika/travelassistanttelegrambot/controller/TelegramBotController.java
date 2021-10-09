package org.vnvika.travelassistanttelegrambot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/city/{cityId}")
    public ResponseEntity<CityDto> update(@Valid @RequestBody CityDto cityDto, @PathVariable Long cityId) {
        City city = cityService.update(cityDto, cityId);
        return ResponseEntity.ok(CityMapper.INSTANCE.toDTO(city));
    }

    @DeleteMapping("/city/{cityId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable long cityId) {
        cityService.delete(cityId);
    }

}
