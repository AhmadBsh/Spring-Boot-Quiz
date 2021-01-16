package com.example.demo.Repositories;

import com.example.demo.Entities.SalesEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends CrudRepository<SalesEntity,Long> {
    
}
