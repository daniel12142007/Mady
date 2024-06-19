package com.example.mady.repository;

import com.example.mady.dto.response.MadyModelResponse;
import com.example.mady.model.MadyModel;
import com.example.mady.model.enums.FormatModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface MadyModelRepository extends JpaRepository<MadyModel, Long> {
    @Query("""
            select new com.example.mady.dto.response.MadyModelResponse(
            mady.id,
            mady.image,
            mady.title,
            mady.description,
            mady.dateCreated,
            mady.formatModel
            )
            from MadyModel mady
            where mady.formatModel = :format
            order by mady.dateCreated
            """)
    List<MadyModelResponse> findWithLimitResponse(@Param("format") FormatModel format, Pageable pageable);

    @Query("""
            select new com.example.mady.dto.response.MadyModelResponse(
            mady.id,
            mady.image,
            mady.title,
            mady.description,
            mady.dateCreated,
            mady.formatModel
            )
            from MadyModel mady
            where mady.id = :id
            """)
    Optional<MadyModelResponse> findByIdResponse(@Param(value = "id") Long id);
}