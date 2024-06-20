package com.wonically.crudent.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(name = "code", unique = true)
    String code;

    @Column(name = "name")
    String name;

    @Column(name = "age")
    Integer age;

    @Column(name = "gender")
    String gender;

    @Column(name = "phone_number", unique = true)
    String phoneNumber;

    @Column(name = "address")
    String address;

    @Column(name = "email", unique = true)
    String email;

    @Column(name = "active")
    Boolean active = true;

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
    Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    Instant updatedAt;
}
