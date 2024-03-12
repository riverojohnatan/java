package com.example.java.model;

import com.example.java.dto.PhoneDTO;
import com.example.java.dto.RegisterUserDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "registered_user")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @ColumnDefault("random_uuid()")
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name="user_phone",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "phone_id")}
    )
    private List<Phone> phones = new ArrayList<>();

    @Column(name = "created")
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "token")
    private String token;

    @Column(name = "active")
    private Boolean active;

    public User(RegisterUserDTO registerUserDTO) {
        this.name = registerUserDTO.getName();
        this.email = registerUserDTO.getEmail();
        this.password = registerUserDTO.getPassword();
        this.created = new Date();
        this.modified = new Date();
        this.lastLogin = new Date();
        this.active = Boolean.TRUE;
        this.token = "TOKEN";
        for(PhoneDTO phoneDTO: registerUserDTO.getPhones()) {
            this.phones.add(Phone.builder()
                        .number(phoneDTO.getNumber())
                        .cityCode(phoneDTO.getCityCode())
                        .countrycode(phoneDTO.getCountryCode())
                    .build());
        }
    }
}
