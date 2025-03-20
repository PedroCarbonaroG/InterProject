package com.interchallange.studyplan.repository;

import com.interchallange.studyplan.domain.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface IProductRepository extends MongoRepository<Product, String> {
}
