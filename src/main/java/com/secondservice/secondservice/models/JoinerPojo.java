package com.secondservice.secondservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class JoinerPojo {
    @JsonProperty("identificationNumber")
    Integer identificationNumber;

    @JsonProperty("name")
    String name;

    @JsonProperty("lastName")
    String lastName;

    @JsonProperty("stack")
    String stack;

    @JsonProperty("role")
    String role;

    @JsonProperty("englishLevel")
    String englishLevel;

    @JsonProperty("domainExperience")
    String domainExperience;
}
