package com.barclays.model;

import jakarta.persistence.*;
import lombok.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
@Entity
//@NoArgsConstructor
@Data
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    private String personName;
    private String emailAddress;
    @OneToOne (cascade = CascadeType.PERSIST)
    private Address address;


    public Person(Integer id, String personName, String emailAddress) {
        this.id = id;
        this.personName = personName;
        this.emailAddress = emailAddress;
    }

    public Person(String personName, String emailAddress) {
        this.personName = personName;
        this.emailAddress = emailAddress;
    }

    public Person() {
    }

}
