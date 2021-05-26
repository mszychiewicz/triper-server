package io.github.mszychiewicz.triperserver.domain;

import io.github.mszychiewicz.triperserver.domain.command.CreateTripCommand;
import io.github.mszychiewicz.triperserver.domain.exception.TripNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TripService {
  public static final String TRIP_NOT_FOUND_MESSAGE = "Trip not found.";

  private final TripRepository tripRepository;
  private final TripFactory tripFactory;

  public UUID createTrip(CreateTripCommand command) {
    Trip createdTrip = tripFactory.from(command);
    return tripRepository.save(createdTrip).getId();
  }

  public Trip getById(UUID id) {
    return tripRepository.findById(id)
        .orElseThrow(() -> new TripNotFoundException(TRIP_NOT_FOUND_MESSAGE));
  }

  public List<Trip> getByDeviceUuid(UUID deviceUuid) {
    return tripRepository.findByDeviceUuid(deviceUuid);
  }
}