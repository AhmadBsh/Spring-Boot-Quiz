package com.example.demo.Repositories;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entities.ProductsEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<ProductsEntity,Long> {
    Optional<ProductsEntity> findByName( String name );
    @Query(
        value = "SELECT * FROM products WHERE  1", 
        nativeQuery = true)
    Optional<List<ProductsEntity>> fetchAllProducts();

    @Modifying
    @Query("update products p set p.name = :name , p.description = :description , p.category = :category , p.quantities = :quantities , p.price = :price where u.id = :id")
    int updateProduct(@Param("name") String name, 
                      @Param("description") String description,
                      @Param("category") String category ,
                      @Param("quantities") int quantities ,
                      @Param("price") double price ,
                      @Param("id") Long id);
          
}
