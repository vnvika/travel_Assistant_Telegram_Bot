package org.vnvika.travelassistanttelegrambot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.vnvika.travelassistanttelegrambot.dto.PlaceDto;
import org.vnvika.travelassistanttelegrambot.model.Place;

@Mapper(componentModel = "spring")
public interface PlaceMapper {
    PlaceMapper INSTANCE = Mappers.getMapper(PlaceMapper.class);

    PlaceDto toDTO(Place place);

    Place fromDTO(PlaceDto placeDto);
}
