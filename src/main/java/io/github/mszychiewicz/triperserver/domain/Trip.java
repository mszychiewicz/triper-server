package io.github.mszychiewicz.triperserver.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Trip {
  @Id
  private UUID id;
  private String name;

  public Trip(String name) {
    this.id = UUID.randomUUID();
    this.name = name;
  }
}
