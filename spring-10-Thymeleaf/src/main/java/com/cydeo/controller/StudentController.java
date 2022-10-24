package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/register") // localhost:8080/student/register
//    @GetMapping("/register")
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model){

        model.addAttribute("students", DataGenerator.createStudent());

        return "student/register";
    }

    @RequestMapping("/drop") // "/student/drop" <= if you don't have the class level @RequestMapping("/students")
    public String drop(){

        return "student/drop";
    }

    @RequestMapping("/welcome") // localhost:8080/student/welcome?name=ozzy
    public String welcome(@RequestParam String name){

        System.out.println(name);
        return "student/welcome";
    }
}
