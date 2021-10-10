package org.vnvika.travelassistanttelegrambot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vnvika.travelassistanttelegrambot.dto.CityDto;
import org.vnvika.travelassistanttelegrambot.mapper.CityMapper;
import org.vnvika.travelassistanttelegrambot.model.City;
import org.vnvika.travelassistanttelegrambot.model.Place;
import org.vnvika.travelassistanttelegrambot.repository.CityRepository;
import org.vnvika.travelassistanttelegrambot.repository.PlaceRepository;
import org.vnvika.travelassistanttelegrambot.service.CityService;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final PlaceRepository placeRepository;

    @Override
    @Transactional
    public City save(CityDto cityDto) {
        final City city = CityMapper.INSTANCE.fromDTO(cityDto);
        city.setId(UUID.randomUUID().getMostSignificantBits());

        City findSameCity = cityRepository.findByNameCity(city.getNameCity());
        if (findSameCity == null) {
            cityRepository.save(city);
            city.setPlaces(iteratePlaces(city));
            log.info("Created city {}", city);
        }
        return city;
    }

    @Override
    @Transactional
    public City update(CityDto cityDto, Long cityId) {
        final City city = cityRepository.findById(cityId).orElseThrow(IllegalArgumentException::new);
        final City changeCity = CityMapper.INSTANCE.fromDTO(cityDto);
        city.setNameCity(changeCity.getNameCity());
        city.setPlaces(iteratePlaces(changeCity));
        log.info("Update completed");
        return cityRepository.save(city);
    }

    @Override
    @Transactional
    public void delete(Long cityId) {
        if (cityRepository.findById(cityId).isPresent()) {
            placeRepository.deleteAllByCity_Id(cityId);
            cityRepository.deleteById(cityId);
            log.info("Delete completed");
        } else {
            throw new IllegalArgumentException("City not found");
        }
    }


    private Set<Place> iteratePlaces(City city) {
        final Set<Place> places = new HashSet<>();
        for (Place place : city.getPlaces()) {
            Place currentPlace = placeRepository.findByNamePlace(place.getNamePlace());
            if (currentPlace == null) {
                place.setCity(city);
                currentPlace = placeRepository.save(place);
                log.info("Saved place {}", currentPlace);
            }
            places.add(currentPlace);
        }
        return places;
    }
}
