package com.cydeo.controller;

import com.cydeo.dto.StudentDTO;
import com.cydeo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService studentService;

    @Test // testing getStudent() with the end point /student
    void getStudent_Test() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/student")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"firstName\" :  \"Mike\", \"lastName\" :  \"Smith\", \"age\" :  20}"))
                .andDo(print())
                .andReturn();

    }

    @Test
    void jsonAssert_Test() throws Exception { // not the most preferred way

        String expected = "{\"firstName\": \"Mike\", \"lastName\":  \"Smith\", \"age\": 20}";
        String actual = mvc.perform(MockMvcRequestBuilders.get("/student")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        // expected -> {"firstName": "Mike", "lastName":  "Smith", "age": 20}
        // actual   -> {"firstName": "Mike", "lastName":  "Smith", "age": 20}

        JSONAssert.assertEquals(expected, actual, false);

    }

    @Test // testing getStudents()
    void getStudents_Test() throws Exception {

        //here we are creating stubs-defining behaviour for mock object of StudentService
        when(studentService.getStudents()).thenReturn(Arrays.asList(
                new StudentDTO("John", "Doe", 20),
                new StudentDTO("Tom", "Hanks", 50)
        ));


        mvc.perform(MockMvcRequestBuilders.get("/students")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content()
                .json("[{\"firstName\" : \"John\", \"lastName\" : \"Doe\", \"age\" : 20}, " +
                                 "{\"firstName\" :  \"Tom\", \"lastName\" :  \"Hanks\", \"age\" :  50}]"))
//                .andDo(print()) // to see on console
                .andReturn();

    }

}
