package com.cydeo.controller;

import com.cydeo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {


    @RequestMapping("/register")
    public String register (Model model){

        model.addAttribute("employee", new Employee());

        return "/employee/employee-register";
    }


    @PostMapping("/confirm")
    public String confirm (@ModelAttribute("employee") Employee employee, Model model){

        List<Employee> employees = new ArrayList<>();

        employees.add(employee);

        model.addAttribute("employeeList", employees);

//        model.addAttribute("employee", new Employee());

        return "/employee/employee-confirm";
    }

}
