package io.github.mszychiewicz.triperserver.domain;

import io.github.mszychiewicz.triperserver.domain.command.CreateTripCommand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Place {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String name;
  private Double longitude;
  private Double latitude;
  @Embedded
  private Address address;

  public Place(String name, Double longitude, Double latitude, Address address) {
    this.name = name;
    this.longitude = longitude;
    this.latitude = latitude;
    this.address = address;
  }
}
