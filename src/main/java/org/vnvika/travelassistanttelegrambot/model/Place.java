package org.vnvika.travelassistanttelegrambot.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "place")
@Data
public class Place {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "namePlace")
    private String namePlace;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "places", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private Set<City> cities;
}
