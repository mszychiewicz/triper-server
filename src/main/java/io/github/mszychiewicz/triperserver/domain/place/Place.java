package io.github.mszychiewicz.triperserver.domain.place;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Place {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String name;
  private String note;
  private Double longitude;
  private Double latitude;
  @Embedded
  private Address address;

  public Place(String name, String note, Double longitude, Double latitude, Address address) {
    this.name = name;
    this.note = note;
    this.longitude = longitude;
    this.latitude = latitude;
    this.address = address;
  }
}
