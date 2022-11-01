package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-------------REGIONS-------------");

        System.out.print("findByCountry: ");
        System.out.println(regionRepository.findByCountry("Canada"));

        System.out.print("findByCountryContaining: ");
        System.out.println(regionRepository.findByCountryContaining("United"));


        System.out.print("findByCountryContainsOrderByRegion: ");
        System.out.println(regionRepository.findByCountryContainsOrderByRegion("United"));

        System.out.print("findTop2ByCountry: ");
        System.out.println(regionRepository.findTop2ByCountry("United States"));

        System.out.print("findTopByCountryContainsOrderByRegion: ");
        System.out.println(regionRepository.findTopByCountryContainsOrderByRegion("United"));

        System.out.println("-------------DEPARTMENTS-------------");

        System.out.print("findByDepartment: ");
        System.out.println(departmentRepository.findByDepartment("Furniture"));

        System.out.print("departmentRepository: ");
        System.out.println(departmentRepository.findByDivision("Health"));

        System.out.print("indByDivisionEndsWith: ");
        System.out.println(departmentRepository.findByDivisionEndsWith("ics"));

        System.out.print("findDistinctTop3ByDivisionContaining: ");
        System.out.println(departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));

        System.out.println("-------------EMPLOYEES-------------");

        System.out.println(employeeRepository.retrieveEmployeeDetail());

        System.out.println(employeeRepository.retrieveEmployeeSalary());
    }
}
