package com.wonically.crudent.controller;

import com.wonically.crudent.entity.Student;
import com.wonically.crudent.util.ResponseFailure;
import com.wonically.crudent.util.ResponseSuccess;
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
    public ResponseSuccess getAll() {
        try {
            return new ResponseSuccess(HttpStatus.OK, "Users list");
        } catch (Exception e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/post")
    public ResponseSuccess postNewStudent(@Valid @RequestBody Student newStudent) {
        try {
            return new ResponseSuccess(HttpStatus.CREATED, "Student " + newStudent.getName() + " created successfully.", 1);
        } catch (Exception e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/put/{code}")
    public ResponseSuccess put(@PathVariable @Pattern(regexp = "^S[0-9]{3}$", message = "Code must be from S001 to S999.") String code, @Valid @RequestBody Student updatedStudent) {
        try {
            return new ResponseSuccess(HttpStatus.ACCEPTED, "Student " + updatedStudent.getName() + " updated successfully.");
        } catch (Exception e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PatchMapping("/patch/{code}")
    public ResponseSuccess patch(@PathVariable @Pattern(regexp = "^S[0-9]{3}$", message = "Code must be from S001 to S999.") String code, @Valid @RequestBody Student updatedStudent) {
        try {
            return new ResponseSuccess(HttpStatus.ACCEPTED, "Student " + updatedStudent.getName() + " updated successfully.");
        } catch (Exception e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/delete/{code}")
    public ResponseSuccess delete(@PathVariable @Pattern(regexp = "^S[0-9]{3}$", message = "Code must be from S001 to S999.") String code) {
        try {
            return new ResponseSuccess(HttpStatus.NO_CONTENT, "Student deleted successfully.");
        } catch (Exception e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
