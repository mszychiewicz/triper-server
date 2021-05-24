package io.github.mszychiewicz.triperserver.domain;

import io.github.mszychiewicz.triperserver.domain.command.CreateTripCommand;
import io.github.mszychiewicz.triperserver.domain.exception.TripNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TripService {
  public static final String TRIP_NOT_FOUND_MESSAGE = "Trip not found.";
  private final TripRepository tripRepository;

  public Trip createTrip(CreateTripCommand command) {
    Trip createdTrip = new Trip(command.getName());
    return tripRepository.save(createdTrip);
  }

  public Trip getById(UUID id) {
    return tripRepository.findById(id)
        .orElseThrow(() -> new TripNotFoundException(TRIP_NOT_FOUND_MESSAGE));
  }
}