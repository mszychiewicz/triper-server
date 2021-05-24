package io.github.mszychiewicz.triperserver.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripResponse {
  Long id;
  String name;
}