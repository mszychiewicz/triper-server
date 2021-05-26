package io.github.mszychiewicz.triperserver.domain.place;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Address {
  String street;
  String city;
  String state;
  String postalCode;
  String country;
  String subLocality;

  public Address(
      String street,
      String city,
      String state,
      String postalCode,
      String country,
      String subLocality) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
    this.country = country;
    this.subLocality = subLocality;
  }
}
