package com.hellokoding.auth.model;

import javax.persistence.*;
import java.util.Set;
import lombok.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Transient
    private String passwordConfirm;

    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Column(name = "company_id", nullable = false)
    private company_id;
}
