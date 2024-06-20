package com.wonically.crudent.school.entity;

import com.wonically.crudent.student.entity.Student;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "school")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(name = "code", unique = true)
    String code;

    @Column(name = "name")
    String name;

    @Column(name = "address", unique = true)
    String address;

    @Column(name = "type")
    String type;

    @Column(name = "level")
    String level;

    @Column(name = "website", unique = true)
    String website;

    @Column(name = "email", unique = true)
    String email;

    @Column(name = "active")
    Boolean active = true;

    @Column(name = "created_at")
    @CreationTimestamp
    Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    Instant updatedAt;

    @OneToMany(mappedBy = "code", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Student> student;
}
