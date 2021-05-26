package io.github.mszychiewicz.triperserver.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressRequest {
  String street;

  String city;

  String state;

  String postalCode;

  String country;

  String subLocality;
}
