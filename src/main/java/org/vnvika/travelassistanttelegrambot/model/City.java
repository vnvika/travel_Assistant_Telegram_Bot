package org.vnvika.travelassistanttelegrambot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "city")
@Data
@Setter
public class City {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nameCity")
    private String nameCity;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "city")
    private Set<Place> places;

}
