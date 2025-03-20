package com.interchallange.studyplan.repository;

import com.interchallange.studyplan.domain.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepository extends BaseRepository {

    private final IProductRepository repository;

    public Product findById(String id) {
        return repository.findById(id).get();
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void saveAll(Iterable<Product> products) {
        repository.saveAll(products);
    }

}
