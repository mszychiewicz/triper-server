package io.github.mszychiewicz.triperserver.domain.trip;

import io.github.mszychiewicz.triperserver.domain.place.Place;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Trip {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private UUID deviceUuid;
  private Instant created;
  private String name;
  private Double estimatedTime;
  private Double distance;
  @OneToMany(cascade = CascadeType.ALL)
  private List<Place> places;

  public Trip(UUID deviceUuid,
              String name,
              Double estimatedTime,
              Double distance,
              List<Place> places) {
    this.deviceUuid = deviceUuid;
    this.created = Instant.now();
    this.name = name;
    this.estimatedTime = estimatedTime;
    this.distance = distance;
    this.places = places;
  }
}
