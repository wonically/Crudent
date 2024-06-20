package com.wonically.crudent.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Table(name = "school")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(name = "code")
    String code;

    @Column(name = "name")
    String name;

    @Column(name = "address")
    String address;

    @Column(name = "type")
    String type;

    @Column(name = "level")
    String level;

    @Column(name = "website")
    String website;

    @Column(name = "email")
    String email;
}
