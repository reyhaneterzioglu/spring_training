package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // find all courses by category =>   select * from courses where category = ...
    List<Course> findByCategory(String category);


    // find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    // checks if a course with the supplied name exists. Return true if exists
    Boolean existsByName(String name);

    // returns the count of courses for the given category
    Integer countByCategory(String category);

    // fins all the courses that starts with the given course name
    List<Course> findByNameStartsWith(String pattern);

    // find all courses by category and returns a stream
    Stream<Course> streamAllByCategory(String category);

    @Query("select c from Course  c where c.category = :category and c.rating > :rating")
    List<Course> retrieveAllByCategoryAndRatingGreaterThan(@Param("category")String category, @Param("rating") int rating); // order can change
}
