package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // no longer need it
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
