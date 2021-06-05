package io.github.mszychiewicz.triperserver.domain.trip;

import io.github.mszychiewicz.triperserver.domain.command.CreateTripCommand;
import io.github.mszychiewicz.triperserver.domain.place.Address;
import io.github.mszychiewicz.triperserver.domain.place.Place;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TripFactory {
  public Trip from(CreateTripCommand command) {
    return new Trip(
        command.getDeviceUuid(),
        command.getName(),
        command.getEstimatedTime(),
        command.getDistance(),
        command.getPlaces().stream()
            .map(this::from)
            .collect(Collectors.toUnmodifiableList()));
  }

  private Place from(CreateTripCommand.Place command) {
    return new Place(
        command.getName(),
        command.getNote(),
        command.getLongitude(),
        command.getLatitude(),
        from(command.getAddress()));
  }

  private Address from(CreateTripCommand.Address command) {
    return new Address(
        command.getStreet(),
        command.getCity(),
        command.getState(),
        command.getPostalCode(),
        command.getCountry(),
        command.getSubLocality());
  }
}
