package com.interchallange.studyplan.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BaseRepository {

    @Autowired
    protected MongoTemplate template;

    protected <T> Page<T> toPage(Query query, Pageable page, Class<T> clazz) {

        var totalElements = template.count(query, clazz);
        var listOfElements = template.find(query.with(page), clazz);

        return new PageImpl<>(listOfElements, page, totalElements);
    }

}
