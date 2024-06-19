package com.wonically.crudent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "active")
    private Boolean active = true;

/*
    @Column(name = "height")
//    @NotNull(message = "Height must not be null.")
//    @Range(min = 100, max = 250, message = "Height must be from 100 to 250 centimeters.")
    private float height;
    @Column(name = "weight")
//    @NotNull(message = "Weight must not be null.")
//    @Range(min = 30, max = 200, message = "Weight must be from 30 to 200 kilograms.")
    private float weight;
    @Column(name = "blood_type")
//    @NotBlank(message = "Blood type must not be blank.")
//    @Pattern(regexp = "^(O|A|B|AB)([+\\-])?$", message = "Blood type must be O, A, B, or AB, either with or without + and - type.")
    private String bloodType;
    @Column(name = "nationality")
//    @NotBlank(message = "Nationality must not be blank.")
    private String nationality;
*/

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;
}
