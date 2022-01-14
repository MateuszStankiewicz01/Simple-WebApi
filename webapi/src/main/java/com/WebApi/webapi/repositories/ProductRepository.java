package com.WebApi.webapi.repositories;

import com.WebApi.webapi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT * FROM Product p WHERE p.id=:selectedId",nativeQuery = true)
    Product findById(@Param("selectedId") long id);

}
