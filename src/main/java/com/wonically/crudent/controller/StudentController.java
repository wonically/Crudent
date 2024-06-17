package com.wonically.crudent.controller;

import com.wonically.crudent.entity.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class StudentController {
    @GetMapping("/get")
    public String get() {
        return "get";
    }

    @PostMapping("/post")
    public String post(@RequestBody Student newStudent) {
        return "post";
    }

    @PutMapping("/put")
    public String put() {
        return "put";
    }

    @PatchMapping("/patch")
    public String patch() {
        return "patch";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "delete";
    }
}
