package com.barclays.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue

    private Integer id;
    private String lineOne;
    private String lineTwo;
    private String state;
    private String postalCode;
    private String country;
}
