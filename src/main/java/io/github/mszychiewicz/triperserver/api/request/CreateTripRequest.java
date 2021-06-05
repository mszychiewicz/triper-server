package io.github.mszychiewicz.triperserver.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotNull
    Double estimatedTime;

    @NotNull
    Double distance;

    @Valid
    List<CreatePlaceRequest> places;
}