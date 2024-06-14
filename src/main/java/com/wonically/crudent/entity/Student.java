package com.wonically.crudent.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    @NotNull
    private String code;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "age")
    @NotNull
    private int age;

    @Column(name = "gender")
    @NotNull
    private String gender;

    @Column(name = "phone_number")
    @NotNull
    @Pattern(regexp = "^$")
    private String phoneNumber;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "height")
    @NotNull
    private float height;

    @Column(name = "weight")
    @NotNull
    private float weight;

    @Column(name = "blood_type")
    @NotNull
    @Pattern(regexp = "^(O|A|B|AB)[+-]?$")
    private String bloodType;

    @Column(name = "nationality")
    @NotNull
    private String nationality;

    @Column(name = "created_at")
    @NotNull
    private String createdAt;

    @Column(name = "updated_at")
    @NotNull
    private String updatedAt;
}
