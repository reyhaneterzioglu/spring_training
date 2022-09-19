package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model) {

        // method of the model interface

        model.addAttribute("name", "cydeo");
        model.addAttribute("course", "MVC");


        return "student/welcome"; //   /student/welcome
        // this time we don't put .html because this is converted to thymeleaf unlike the other html files
    }
}
