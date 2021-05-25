package io.github.mszychiewicz.triperserver.api;

import io.github.mszychiewicz.triperserver.api.request.AddressDto;
import io.github.mszychiewicz.triperserver.api.request.CreateTripRequest;
import io.github.mszychiewicz.triperserver.api.request.PlaceDto;
import io.github.mszychiewicz.triperserver.api.response.CreateTripResponse;
import io.github.mszychiewicz.triperserver.api.response.GetTripResponse;
import io.github.mszychiewicz.triperserver.domain.Trip;
import io.github.mszychiewicz.triperserver.domain.command.CreateTripCommand;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
class TripApiMapper {
  public CreateTripCommand toCommand(CreateTripRequest request) {
    return new CreateTripCommand(
        request.getDeviceUuid(),
        request.getName(),
        request.getPlaces().stream()
            .map(this::toCommand)
            .collect(Collectors.toUnmodifiableList()));
  }

  private CreateTripCommand.Place toCommand(PlaceDto request) {
    return new CreateTripCommand.Place(
        request.getName(),
        request.getLongitude(),
        request.getLatitude(),
        toCommand(request.getAddress()));
  }

  private CreateTripCommand.Address toCommand(AddressDto request) {
    return new CreateTripCommand.Address(
        request.getStreet(),
        request.getCity(),
        request.getState(),
        request.getPostalCode(),
        request.getCountry(),
        request.getSubLocality());
  }

  public CreateTripResponse toResponse(UUID tripId) {
    return new CreateTripResponse(tripId);
  }

  public GetTripResponse toResponse(Trip trip) {
    return new GetTripResponse(
        trip.getId(),
        trip.getName());
  }
}
