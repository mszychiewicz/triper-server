package io.github.mszychiewicz.triperserver.api;

import io.github.mszychiewicz.triperserver.api.dto.CreateTripRequest;
import io.github.mszychiewicz.triperserver.api.dto.TripResponse;
import io.github.mszychiewicz.triperserver.domain.Trip;
import io.github.mszychiewicz.triperserver.domain.command.CreateTripCommand;
import org.springframework.stereotype.Component;

@Component
class TripApiMapper {
  public CreateTripCommand toCommand(CreateTripRequest request) {
    return new CreateTripCommand(
        request.getName());
  }

  public TripResponse toResponse(Trip trip) {
    return new TripResponse(
        trip.getId(),
        trip.getName());
  }
}
