package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController {

    @RequestMapping("/mentors")
    public String mentorList(Model model) {

        List<Mentor> mentorList = new ArrayList<>();

        Mentor mentor1 = new Mentor("Mike", "Smith", 45, Gender.MALE);
        Mentor mentor2 = new Mentor("Tom", "Hanks", 65, Gender.MALE);
        Mentor mentor3 = new Mentor("Ammy", "Bryan", 25, Gender.FEMALE);

        mentorList.add(mentor1);
        mentorList.add(mentor2);
        mentorList.add(mentor3);

        model.addAttribute("mentors", mentorList);

//        model.addAttribute("mentor1", mentor1);
//        model.addAttribute("mentor2", mentor2);
//        model.addAttribute("mentor3", mentor3);

        return "mentor/mentorInfo";

    }
}
