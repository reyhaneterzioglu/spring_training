package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //display all employees with email address "..";
    List<Employee> findByEmail(String email);

    //display all employees with first name "" and last name "", also show all employees with email address with ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //display all employees that first name is not ""
    List<Employee> findByFirstNameIsNot(String firstName);

    //display all employees where last name starts with ""
    List<Employee> findByLastNameStartingWith(String pattern);

    //display all employees with salaries higher than ""
    List<Employee> findBySalaryGreaterThan(BigDecimal salary);

    //display all employees with salaries less than ""
    List<Employee> findBySalaryLessThan(BigDecimal salary);

    //display all employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate d1, LocalDate d2);

    //display all employees where salaries greater and equal to "" in order-salary
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(BigDecimal salary);

    //display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(BigDecimal salary);

    //display all employees that do not have email address
    List<Employee> findByEmailNull();

    //JPQL - if the derived query requires many parameters, it is better to use JPQL or native query (pure sql)
    @Query("SELECT e FROM Employee e WHERE e.email = 'amcnee1@google.es'")
    // e can be any name, it represent an object of Employee class
    Employee retrieveEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email = 'amcnee1@google.es'")
        //SELECT salary from Employee would be the regular sql query which works directly with db
    Integer retrieveEmployeeSalary();


    // not equal
    @Query("SELECT e FROM Employee  e WHERE e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    //like/constraints/startsWith/endsWith
    @Query("SELECT e FROM Employee  e WHERE e.firstName LIKE ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    // less than
    @Query("select e.firstName from Employee e where e.salary < ?1")
    List<String> retrieveEmployeeNameSalaryLessThan(int s);

    // greater than
    @Query("select e.firstName from Employee e where e.salary > ?1")
    List<String> retrieveEmployeeNameSalaryGreaterThan(int s);

    // between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int range1, int range2);


    // before
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    // null
    @Query("SELECT e FROM Employee e WHERE e.email is null ")
    List<Employee> retrieveEmployeeEmailIsNull();

    // not null
    @Query("SELECT e FROM Employee e WHERE e.email is not null ")
    List<Employee> retrieveEmployeeEmailIsNotNull();

    //SORTING in ASC order
    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    //SORTING in DESC order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC ")
    List<Employee> retrieveEmployeeSalaryOrderDesc();

    //native query
    @Query(value = "select * from employees where salary =?1", nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);

    //named parameter
    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);
}
