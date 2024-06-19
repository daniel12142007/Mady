package com.example.mady.repository;

import com.example.mady.dto.response.AboutCityResponse;
import com.example.mady.model.AboutCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AboutCityRepository extends JpaRepository<AboutCity, Long> {
    @Query("""
            select new com.example.mady.dto.response.AboutCityResponse(
            about.about,
            about.description,
            about.video
            )
            from AboutCity about
            order by about.id
            """)
    List<AboutCityResponse> findAllResponse();
}