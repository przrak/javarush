package ru.javarush.pr1zrak.testtask.service;

import org.springframework.data.domain.Pageable;
import ru.javarush.pr1zrak.testtask.entity.Part;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PartService {
    Part getPartById(Long id);
    void savePart(Part part);
    void updatePartById(Long id, String name, boolean need, Integer quantity);
    void deletePartById(Long id);
    Page<Part> findAll(Pageable page);
    List<Part> findByNeedStatus(Boolean need);
    Page<Part> findFiltered(Boolean need, Pageable pageable);
    Page<Part> findByName(String name, Pageable pageable);
}
