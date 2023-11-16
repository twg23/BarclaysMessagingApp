package com.barclays.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class HolidaySeason {
    @Id
    @GeneratedValue
    private Integer id;
    private String holidayType;
    private String holidaySeason;

}
