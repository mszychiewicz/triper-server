package io.github.mszychiewicz.triperserver.domain;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;
@Repository
interface TripRepository extends JpaRepository<Trip, UUID> {
    Trip save(Trip trip);
    Optional<Trip> findById(UUID id);
}
