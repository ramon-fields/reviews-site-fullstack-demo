package com.example.fullstackdemo.repositories;

import com.example.fullstackdemo.models.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Long> {
}