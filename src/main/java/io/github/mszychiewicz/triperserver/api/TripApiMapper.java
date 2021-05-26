package io.github.mszychiewicz.triperserver.api;

import io.github.mszychiewicz.triperserver.api.request.CreateAddressRequest;
import io.github.mszychiewicz.triperserver.api.request.CreateTripRequest;
import io.github.mszychiewicz.triperserver.api.request.CreatePlaceRequest;
import io.github.mszychiewicz.triperserver.api.response.CreateTripResponse;
import io.github.mszychiewicz.triperserver.api.response.GetAddressResponse;
import io.github.mszychiewicz.triperserver.api.response.GetPlaceResponse;
import io.github.mszychiewicz.triperserver.api.response.GetTripResponse;
import io.github.mszychiewicz.triperserver.domain.place.Address;
import io.github.mszychiewicz.triperserver.domain.place.Place;
import io.github.mszychiewicz.triperserver.domain.trip.Trip;
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

  private CreateTripCommand.Place toCommand(CreatePlaceRequest request) {
    return new CreateTripCommand.Place(
        request.getName(),
        request.getLongitude(),
        request.getLatitude(),
        toCommand(request.getAddress()));
  }

  private CreateTripCommand.Address toCommand(CreateAddressRequest request) {
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
        trip.getDeviceUuid(),
        trip.getName(),
        trip.getPlaces().stream()
            .map(this::toResponse)
            .collect(Collectors.toUnmodifiableList()));
  }

  private GetPlaceResponse toResponse(Place place) {
    return new GetPlaceResponse(
        place.getName(),
        place.getLongitude(),
        place.getLatitude(),
        toResponse(place.getAddress()));
  }

  private GetAddressResponse toResponse(Address address) {
    return new GetAddressResponse(
        address.getStreet(),
        address.getCity(),
        address.getState(),
        address.getPostalCode(),
        address.getCountry(),
        address.getSubLocality());
  }
}
