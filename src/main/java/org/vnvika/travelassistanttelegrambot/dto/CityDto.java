package org.vnvika.travelassistanttelegrambot.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@NoArgsConstructor
public class CityDto {
    @NotBlank
    private String nameCity;
    private Set<PlaceDto> places;
}
