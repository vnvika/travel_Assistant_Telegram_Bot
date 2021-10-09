package org.vnvika.travelassistanttelegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vnvika.travelassistanttelegrambot.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
