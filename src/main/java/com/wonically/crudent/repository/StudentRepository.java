package com.wonically.crudent.repository;

import com.wonically.crudent.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();

    Student findStudentById(Long id);

    Student findStudentByCode(String code);

    List<Student> findStudentByNameContaining(String name);

    List<Student> findStudentByAge(int age);

    List<Student> findStudentByGender(String gender);

    List<Student> findStudentByPhoneNumberContaining(String phoneNumber);

    List<Student> findStudentByEmailContaining(String email);

    List<Student> findStudentByHeightBetweenOrderByHeightAsc(float lowHeight, float highHeight);

    List<Student> findStudentByWeightBetweenOrderByWeightAsc(float lowWeight, float highWeight);

    List<Student> findStudentByBloodTypeStartingWith(String bloodType);

    List<Student> findStudentByNationality(String nationality);

    List<Student> findStudentByCreatedAtAfterOrderByCreatedAtAsc(String createdAt);

    List<Student> findStudentByUpdatedAtAfterOrderByUpdatedAtAsc(String updatedAt);

    void deleteStudentById(Long id);

    void deleteStudentByCode(String code);

    @Modifying
    @Query("UPDATE Student s SET s.name = :name, s.age = :age, s.gender = :gender, s.phoneNumber = :phoneNumber, s.address = :address, s.email = :email, s.height = :height, s.weight = :weight, s.bloodType = :bloodType, s.nationality = :nationality, s.updatedAt = :updatedAt WHERE s.id = :id")
    Student updateByStudent(@Param("id") Long id,
                         @Param("name") String name,
                         @Param("age") int age,
                         @Param("gender") String gender,
                         @Param("phoneNumber") String phoneNumber,
                         @Param("address") String address,
                         @Param("email") String email,
                         @Param("height") float height,
                         @Param("weight") float weight,
                         @Param("bloodType") String bloodType,
                         @Param("nationality") String nationality,
                         @Param("updatedAt") String updatedAt);
}
