package com.barclays.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity //  tells spring to create databasease  table  to store objects of this class e. id & content
//@NoArgsConstructor
@Data
public class Message {
    @Id
    @GeneratedValue // allows incremental value to id
    private Integer id;

    private String content;

    @OneToOne (cascade = CascadeType.PERSIST)
    private HolidaySeason holidaySeason;

    public Message(String content) {
        this.content = content;
    }

    public Message() {

    }


}
