package org.vnvika.travelassistanttelegrambot.service;

import org.vnvika.travelassistanttelegrambot.dto.CityDto;
import org.vnvika.travelassistanttelegrambot.model.City;


public interface CityService {
    City save(CityDto cityDto);
}
