package com.wonically.crudent.controller;

import com.wonically.crudent.entity.Student;
import com.wonically.crudent.util.ResponseData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping
public class StudentController {
    @GetMapping("/list")
    public ResponseData<?> getAll() {
        return new ResponseData<>(HttpStatus.OK.value(), "Students");
    }

    @PostMapping("/post")
    public ResponseData<?> postNewStudent(@Valid @RequestBody Student newStudent) {
        return new ResponseData<>(HttpStatus.CREATED.value(), "Student " + newStudent.getName() + " created successfully.", 1);
    }

    @PutMapping("/put/{code}")
    public ResponseData<?> put(@PathVariable @Pattern(regexp = "^S[0-9]{3}$", message = "Code must be from S001 to S999.") String code, @Valid @RequestBody Student updatedStudent) {
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "Student " + updatedStudent.getName() + " updated successfully.");
    }

    @PatchMapping("/patch/{code}")
    public ResponseData<?> patch(@PathVariable @Pattern(regexp = "^S[0-9]{3}$", message = "Code must be from S001 to S999.") String code, @Valid @RequestBody Student patchedStudent) {
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "Student " + patchedStudent.getName() + " patched successfully.");
    }

    @DeleteMapping("/delete/{code}")
    public ResponseData<?> delete(@PathVariable @Pattern(regexp = "^S[0-9]{3}$", message = "Code must be from S001 to S999.") String code) {
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Student deleted successfully.");
    }
}
