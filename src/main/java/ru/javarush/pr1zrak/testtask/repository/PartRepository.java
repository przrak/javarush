package ru.javarush.pr1zrak.testtask.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.javarush.pr1zrak.testtask.entity.Part;

import java.util.List;

public interface PartRepository extends PagingAndSortingRepository<Part, Long> {

    @Query("SELECT p FROM Part p WHERE p.need = :need")
    List<Part> findByNeedStatus(@Param("need") Boolean need);
    @Query("SELECT p FROM Part p WHERE p.need = :need")
    Page<Part> findFiltered(@Param("need") Boolean need, Pageable pageable);
    @Query("SELECT p FROM Part p WHERE p.name = :name")
    Page<Part> findByName(@Param("name") String name, Pageable pageable);
}