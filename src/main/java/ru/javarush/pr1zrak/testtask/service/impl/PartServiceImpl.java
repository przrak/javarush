package ru.javarush.pr1zrak.testtask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.javarush.pr1zrak.testtask.entity.Part;
import ru.javarush.pr1zrak.testtask.repository.PartRepository;
import ru.javarush.pr1zrak.testtask.service.PartService;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {
    private PartRepository repository;

    @Autowired
    public void setRepository(PartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Part getPartById(Long id) {
        try {
            if (repository.findById(id).isPresent()) {
                return repository.findById(id).get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void savePart(Part part) {
        repository.save(part);
    }

    @Override
    public void updatePartById(Long id, String name, boolean need, Integer quantity) {
        try {
            if (repository.findById(id).isPresent()) {
                Part updated = repository.findById(id).get();
                updated.setName(name);
                updated.setNeed(need);
                updated.setQuantity(quantity);
                repository.save(updated);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePartById(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Page<Part> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Part> findByNeedStatus(Boolean need) {
        return repository.findByNeedStatus(need);
    }

    @Override
    public Page<Part> findFiltered(Boolean need, Pageable pageable) {
        return repository.findFiltered(need, pageable);
    }

    @Override
    public Page<Part> findByName(String name, Pageable pageable) {
        return repository.findByName(name, pageable);
    }
}
