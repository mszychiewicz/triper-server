package io.github.mszychiewicz.triperserver.domain;

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
  private String name;
  @OneToMany(cascade=CascadeType.ALL)
  private List<Place> places;

  public Trip(UUID deviceUuid, String name, List<Place> places) {
    this.deviceUuid = deviceUuid;
    this.name = name;
    this.places = places;
  }
}
