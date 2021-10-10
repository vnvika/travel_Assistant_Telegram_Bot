package org.vnvika.travelassistanttelegrambot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "place")
@Data
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "namePlace")
    private String namePlace;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

}
