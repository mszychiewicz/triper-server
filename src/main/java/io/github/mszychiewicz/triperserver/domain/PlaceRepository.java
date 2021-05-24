package io.github.mszychiewicz.triperserver.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface PlaceRepository extends JpaRepository<Place, Long> {
  Place save(Place place);

  Optional<Place> findById(Long id);
}
