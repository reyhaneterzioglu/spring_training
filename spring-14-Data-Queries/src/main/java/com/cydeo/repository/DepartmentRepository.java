package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    //display all departments in the furniture department
    List<Department> findByDepartment(String department);

    //display all departments in the health division
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division); // all three same thing

    //display all departments with division name ends with 'ics'
    List<Department> findByDivisionEndsWith(String pattern);

    //display top 3 departments with division name includes 'Hea' without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String pattern);

//    @Query(value = "select * from departments group by division", nativeQuery = true)
    @Query("select d from Department d where d.division in(?1)")
    List<Department> retrieveDepartmentDivision(List<String> divisions);
}
