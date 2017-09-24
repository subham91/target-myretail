package com.target.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.target.domain.ProductPrice;


public interface ProductPriceRepository extends MongoRepository<ProductPrice, Long> {

}
