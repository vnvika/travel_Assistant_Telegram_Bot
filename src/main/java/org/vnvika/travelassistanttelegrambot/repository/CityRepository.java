package org.vnvika.travelassistanttelegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vnvika.travelassistanttelegrambot.model.City;

public interface CityRepository extends JpaRepository<City,Long> {
}
