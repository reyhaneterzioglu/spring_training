package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name

    List<Cinema> findByName(String name); // you can say Cinema as return type as well, or Optional<Cinema> in case it is null

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name

    List<Cinema> findTop3BySponsoredNameContainingOrderBySponsoredName(String sponsoredName); // findFirst3By...

    //Write a derived query to list all cinemas in a specific country

    List<Cinema> findByLocationCountry(String country); //does not work


    //Write a derived query to list all cinemas with a specific name or sponsored name

    List<Cinema> findByNameOrSponsoredName(String name, String sponsoredName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id

    @Query("select c.name from Cinema c where c.id = ?1")
    String findNameById(Long id);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "select * from cinema c join location l on c.location_id=l.id where l.country = ?1", nativeQuery = true)
    List<Cinema> readAllByCountry(@Param("country") String country);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern

    @Query(value = "select * from cinema where name ilike %?1% or sponsored_name like %?1%", nativeQuery = true)
    List<Cinema> readAllByNameOrSponsoredNameContaining(String pattern);

    //Write a native query to sort all cinemas by name

    @Query(value = "select * from cinema order by name", nativeQuery = true)
    List<Cinema> readAllByOrderByName();

    //Write a native query to distinct all cinemas by sponsored name

    @Query(value = "select distinct sponsored_name from cinema", nativeQuery = true)
    List<String> findDistinctBySponsoredName();

}
