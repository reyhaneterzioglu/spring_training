package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?

    List<User> findByEmail(String email);

    //Write a derived query to read a user with a username?

    List<User> findByUsername(String username);

    //Write a derived query to list all users that contain a specific name?

    List<User> findByAccountNameContaining(String name);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?

    List<User> findAllByAccountNameContainingIgnoreCase(String name);

    //Write a derived query to list all users with an age greater than a specified age?

    List<User> findAllByAccountAgeGreaterThan(Integer age);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?

    @Query("select u from User  u where u.email=?1")
    List<User> retrieveByEmail(String email);

    //Write a JPQL query that returns a user read by username?

    @Query("select u from User  u where u.username=?1")
    List<User> retrieveByUsername(String username);

    //Write a JPQL query that returns all users?

    @Query("select u from User u")
    List<User> retrieveAll();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?

    @Query(value = "select * from user_account u join account_details ad on ad.id = u.account_details_id where ad.name like %:name%", nativeQuery = true)
    List<User> retrieveAllContainsName(String name);

    //Write a native query that returns all users?

    @Query(value = "select * from user_account", nativeQuery = true)
    List<User> readAll();

    //Write a native query that returns all users in the range of ages?

    @Query(value = "SELECT * FROM user_account u " +
            "JOIN account_details ad ON ad.id = u.account_details_id WHERE ad.age BETWEEN ?1 AND ?2", nativeQuery = true)
    List<User> retrieveBetweenAgeRange(@Param("age1") Integer age1, @Param("age2") Integer age2);

    //Write a native query to read a user by email?

    @Query(value = "select * from user_account where email = ?1", nativeQuery = true)
    List<User> readByEmail(String email);

}
