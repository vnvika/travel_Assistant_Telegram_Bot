package org.vnvika.travelassistanttelegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vnvika.travelassistanttelegrambot.model.Place;

import java.util.Set;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByNamePlace(String placeName);
    void deleteAllByCity_Id(Long city_id);
    Set<Place> findAllByCity_Id(Long city_id);
}
