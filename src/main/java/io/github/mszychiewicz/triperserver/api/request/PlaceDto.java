package io.github.mszychiewicz.triperserver.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDto {
  String name;

  @NotNull
  Double longitude;

  @NotNull
  Double latitude;

  @Valid
  AddressDto address;
}
