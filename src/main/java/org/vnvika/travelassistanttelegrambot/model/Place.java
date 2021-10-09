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
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
