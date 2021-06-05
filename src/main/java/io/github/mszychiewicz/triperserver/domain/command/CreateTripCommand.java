package io.github.mszychiewicz.triperserver.domain.command;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Value
public class CreateTripCommand {
  UUID deviceUuid;
  String name;
  Double estimatedTime;
  Double distance;
  List<Place> places;

  @Value
  public static class Place {
    String name;
    String note;
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
