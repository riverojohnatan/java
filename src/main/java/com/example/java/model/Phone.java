package com.example.java.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "phone")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Phone {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @ColumnDefault("random_uuid()")
    @Column(name = "phone_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "number")
    private String number;

    @Column(name = "citycode")
    private String cityCode;

    @Column(name = "countrycode")
    private String countrycode;

    @ManyToMany(mappedBy = "phones")
    private List<User> users = new ArrayList<>();
}
