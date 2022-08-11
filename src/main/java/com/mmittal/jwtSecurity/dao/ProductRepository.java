package com.mmittal.jwtSecurity.dao;

import com.mmittal.jwtSecurity.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaAuditing
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
