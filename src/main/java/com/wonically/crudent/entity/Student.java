package com.wonically.crudent.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wonically.crudent.util.PhoneNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(name = "code", unique = true)
    @NotBlank(message = "Code must not be blank.")
    @Pattern(regexp = "^S[0-9]{3}$", message = "Code must be from S001 to S999.")
    private String code;

    @Column(name = "name")
    @NotBlank(message = "Name must not be blank.")
    @Pattern(regexp = "^([A-Z][a-z]*\\s?)+[A-Z][a-z]*$", message = "Each word must have its first letter capitalized, separated by one space, and end with a letter.")
    private String name;

    @Column(name = "age")
    @NotNull(message = "Age must not be null.")
    @Range(min = 18, max = 30, message = "Students must be from 18 to 30 years old.")
    private int age;

    @Column(name = "gender")
    @NotBlank(message = "Gender must not be blank.")
    @Pattern(regexp = "male|female", message = "Gender must be male or female.")
    private String gender;

    @Column(name = "phone_number", unique = true)
    @NotBlank(message = "Phone number must not be blank.")
    @PhoneNumber
    private String phoneNumber;

    @Column(name = "address")
    @NotBlank(message = "Address must not be blank.")
    private String address;

    @Column(name = "email", unique = true)
    @NotBlank(message = "Email must not be blank.")
    @Email(message = "Please enter correct email format.")
    private String email;

    @Column(name = "height")
    @NotNull(message = "Height must not be null.")
    @Range(min = 100, max = 250, message = "Height must be from 100 to 250 centimeters.")
    private float height;

    @Column(name = "weight")
    @NotNull(message = "Weight must not be null.")
    @Range(min = 30, max = 200, message = "Weight must be from 30 to 200 kilograms.")
    private float weight;

    @Column(name = "blood_type")
    @NotBlank(message = "Blood type must not be blank.")
    @Pattern(regexp = "^(O|A|B|AB)([+\\-])?$", message = "Blood type must be O, A, B, or AB, either with or without + and - type.")
    private String bloodType;

    @Column(name = "nationality")
    @NotBlank(message = "Nationality must not be blank.")
    private String nationality;

    @Column(name = "status")
    @NotBlank(message = "Student status must not be blank.")
    @Pattern(regexp = "^(active|inactive)$", message = "Student status must be either active or inactive.")
    private String status;

    @Column(name = "created_at")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant updatedAt;
}
