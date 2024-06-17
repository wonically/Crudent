package com.wonically.crudent.controller;

import com.wonically.crudent.entity.Student;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping
public class StudentController {
    @GetMapping("/get")
    public String get() {
        return "get";
    }

    @PostMapping("/post")
    public String post(@Valid @RequestBody Student newStudent) {
        return "post";
    }

    @PutMapping("/put/{code}")
    public String put(@PathVariable @Pattern(regexp = "^S[0-9]{3}$", message = "Code must be from S001 to S999.") String code, @Valid @RequestBody Student updatedStudent) {
        return "put";
    }

    @PatchMapping("/patch/{code}")
    public String patch(@PathVariable @Pattern(regexp = "^S[0-9]{3}$", message = "Code must be from S001 to S999.") String code, @Valid @RequestBody Student updatedStudent) {
        return "patch";
    }

    @DeleteMapping("/delete/{code}")
    public String delete(@PathVariable @Pattern(regexp = "^S[0-9]{3}$", message = "Code must be from S001 to S999.") String code) {
        return "delete";
    }
}
