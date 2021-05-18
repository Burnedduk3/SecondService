package com.secondservice.secondservice.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "new_joiners")
public class Joiner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "identification_number", nullable = false)
    private Integer identificationNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "english_level", nullable = false, length = 24)
    private String englishLevel;

    @Column(name = "domain_experience")
    private String domainExperience;

    @Column(name = "role_id")
    private Integer roleId;

}
