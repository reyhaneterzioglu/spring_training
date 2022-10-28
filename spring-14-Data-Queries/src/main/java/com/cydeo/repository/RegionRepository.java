package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    // display all regions in canada
   List<Region> findByCountry(String country);
   List<Region> getByCountry(String country); // both same thing

   //display all regions with country name includes "United"
   List<Region> findByCountryContaining(String country);
   List<Region> findByCountryContains(String country); // both same

   //display all regions with country name includes "united" in order(region)
   List<Region> findByCountryContainsOrderByRegion(String country);

   //display top two regions in United States
   List<Region> findTopByCountry(String country); // top-limit 1 in sql
   List<Region> findTop2ByCountry(String country); // top-limit 2 in sql

   List<Region> findTopByCountryContainsOrderByRegion(String country);
}
