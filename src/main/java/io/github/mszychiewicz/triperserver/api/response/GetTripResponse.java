package io.github.mszychiewicz.triperserver.api.response;

import io.github.mszychiewicz.triperserver.domain.place.Place;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTripResponse {
  UUID id;
  UUID deviceUuid;
  String name;
  List<GetPlaceResponse> places;
}