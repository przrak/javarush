package ru.javarush.pr1zrak.testtask.service.impl;

import org.junit.Test;
import ru.javarush.pr1zrak.testtask.repository.PartRepository;

import static org.junit.Assert.*;

public class PartServiceImplTest {

    private PartRepository repository;

    @Test
    public void getPartById() {
        repository.findById(5L).get();
    }

    @Test
    public void findAll() {

    }
}