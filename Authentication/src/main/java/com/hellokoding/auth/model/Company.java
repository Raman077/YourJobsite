package com.hellokoding.auth.model;

import javax.persistence.*;
import java.util.Set;
import lombok.*;

@Entity
@Table(name = "company")
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "user")
    private Set<User> users;

}
