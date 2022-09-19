package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage() { // method name not important

        return "home.html"; // www.amazon.com/login -> which end point ? = /login

    }

    @RequestMapping("/ozzy")
    public String getHomePage2() {

        return "home.html";

    }

    @RequestMapping // it will be added as default to initial page localhost:8080 or localhost:8080/
    public String getHomePage3() {

        return "home.html";

    }


    @RequestMapping({"/apple", "/orange" })
    public String getHomePage4() {

        return "home.html";

    }

}
