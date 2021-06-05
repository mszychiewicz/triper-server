package io.github.mszychiewicz.triperserver.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTripInfoResponse {
  UUID id;
  String name;
  Integer numberOfPlaces;
  Double estimatedTime;
  Double distance;
}