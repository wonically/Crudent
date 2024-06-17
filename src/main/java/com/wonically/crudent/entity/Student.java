package com.wonically.crudent.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wonically.crudent.util.PhoneNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Range;

import java.time.Instant;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "code", unique = true)
    @Pattern(regexp = "^S[0-9]{3}$", message = "Code must be from S001 to S999.")
    private String code;

    @Column(name = "name")
    @Pattern(regexp = "^([A-Z][a-z]*\\s?)+[A-Z][a-z]*$", message = "Each word must have its first letter capitalized, separated by one space, and end with a letter.")
    private String name;

    @Column(name = "age")
    @Range(min = 18, max = 30, message = "Students must be from 18 to 30 years old.")
    private int age;

    @Column(name = "gender")
    @Pattern(regexp = "male|female", message = "Gender must be male or female.")
    private String gender;

    @Column(name = "phone_number", unique = true)
    @PhoneNumber
    private String phoneNumber;

    @Column(name = "address")
    @NotBlank
    private String address;

    @Column(name = "email", unique = true)
    @Email(message = "Please enter correct email format.")
    private String email;

    @Column(name = "height")
    @Range(min = 100, max = 250, message = "Height must be from 100 to 250 centimeters.")
    private float height;

    @Column(name = "weight")
    @Range(min = 30, max = 200, message = "Weight must be from 30 to 200 kilograms.")
    private float weight;

    @Column(name = "blood_type")
    @Pattern(regexp = "^(O|A|B|AB)([+\\-])?$", message = "Blood type must be O, A, B, or AB, either with or without + and - type.")
    private String bloodType;

    @Column(name = "nationality")
    @NotBlank
    private String nationality;

    @Column(name = "created_at")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant updatedAt;
}
