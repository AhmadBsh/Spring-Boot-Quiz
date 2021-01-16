package com.example.demo.Repositories;

import java.util.Optional;

import com.example.demo.Entities.ClientsEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends CrudRepository<ClientsEntity,Long> {
    Optional<ClientsEntity> findByName(String name);
}
