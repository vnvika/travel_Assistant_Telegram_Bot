package org.vnvika.travelassistanttelegrambot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.vnvika.travelassistanttelegrambot.dto.CityDto;
import org.vnvika.travelassistanttelegrambot.model.City;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CityDto toDTO(City city);

    City fromDTO(CityDto cityDto);
}
