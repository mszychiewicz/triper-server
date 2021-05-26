package io.github.mszychiewicz.triperserver.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAddressResponse {
  String street;

  String city;

  String state;

  String postalCode;

  String country;

  String subLocality;
}
