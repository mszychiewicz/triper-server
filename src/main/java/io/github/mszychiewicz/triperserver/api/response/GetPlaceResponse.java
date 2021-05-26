package io.github.mszychiewicz.triperserver.api.response;

import io.github.mszychiewicz.triperserver.api.request.CreateAddressRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPlaceResponse {
  String name;

  Double longitude;

  Double latitude;

  GetAddressResponse address;
}
