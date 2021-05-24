package io.github.mszychiewicz.triperserver.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTripRequest {
    @NotBlank
    UUID deviceUuid;

    @NotBlank
    String name;

    @Valid
    List<PlaceDto> places;
}