package io.github.mszychiewicz.triperserver.domain.trip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
interface TripRepository extends JpaRepository<Trip, UUID> {
  Trip save(Trip trip);

  Optional<Trip> findById(UUID id);

  List<Trip> findByDeviceUuid(UUID deviceUuid);
}
