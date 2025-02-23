package com.interchallange.studyplan.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

@Repository
public class BaseRepository {

    @Autowired
    protected MongoTemplate template;

    private static final String SEARCH_BY_APPROXIMATION_AND_CASE_INSENSITIVE = "i";

    protected <T> Page<T> toPage(Query query, Pageable page, Class<T> clazz) {

        var totalElements = template.count(query, clazz);
        var listOfElements = template.find(query.with(page), clazz);

        return new PageImpl<>(listOfElements, page, totalElements);
    }

    protected <T> void addParamToQuery(Query query, String fieldName, T fieldValue) {
        if (possibleToAddParamToQuery(query, fieldName, fieldValue)) {
            if (fieldValue instanceof String) {
                query.addCriteria(Criteria.where(fieldName).regex(fieldValue.toString(), SEARCH_BY_APPROXIMATION_AND_CASE_INSENSITIVE));
            } else {
                query.addCriteria(Criteria.where(fieldName).is(fieldValue));
            }
        }
    }

    private boolean possibleToAddParamToQuery(Object... params) {
        return Stream.of(params).allMatch(Objects::nonNull);
    }

}
