package com.example.fullstackdemo.repositories;

import com.example.fullstackdemo.models.Designer;
import org.springframework.data.repository.CrudRepository;

public interface DesignerRepository extends CrudRepository<Designer, Long> {
}