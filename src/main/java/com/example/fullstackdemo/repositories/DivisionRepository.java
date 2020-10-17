package com.example.fullstackdemo.repositories;

import com.example.fullstackdemo.models.Division;
import org.springframework.data.repository.CrudRepository;

public interface DivisionRepository extends CrudRepository<Division, Long> {
    Division findDivisionByType(String type);
}