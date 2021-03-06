package io.github.mszychiewicz.triperserver.api;

import io.github.mszychiewicz.triperserver.api.request.CreateTripRequest;
import io.github.mszychiewicz.triperserver.api.response.CreateTripResponse;
import io.github.mszychiewicz.triperserver.api.response.GetTripInfoResponse;
import io.github.mszychiewicz.triperserver.api.response.GetTripResponse;
import io.github.mszychiewicz.triperserver.domain.trip.TripService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/trips")
public class TripController {
  private final TripService tripService;
  private final TripApiMapper mapper;

  @PostMapping
  public @ResponseBody
  CreateTripResponse create(@RequestBody @Valid CreateTripRequest request) {
    return mapper.toResponse(
        tripService.createTrip(mapper.toCommand(request))
    );
  }

  @GetMapping
  public @ResponseBody
  List<GetTripInfoResponse> getTrips(@RequestParam(required = false) Optional<UUID> deviceUuid) {
    return deviceUuid.map(tripService::getByDeviceUuid)
        .orElseGet(tripService::getLatest)
        .stream()
        .map(mapper::toInfoResponse)
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public @ResponseBody
  GetTripResponse getById(@PathVariable("id") UUID id) {
    return mapper.toResponse(
        tripService.getById(id)
    );
  }
}