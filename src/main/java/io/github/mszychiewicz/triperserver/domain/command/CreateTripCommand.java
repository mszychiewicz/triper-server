package io.github.mszychiewicz.triperserver.domain.command;

import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class CreateTripCommand {
  UUID deviceUuid;
  String name;
  List<Place> places;

  @Value
  public static class Place {
    String name;
    Double longitude;
    Double latitude;
    Address address;
  }

  @Value
  public static class Address {
    String street;
    String city;
    String state;
    String postalCode;
    String country;
    String subLocality;
  }
}
