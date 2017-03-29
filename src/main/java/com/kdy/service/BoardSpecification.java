package com.kdy.service;

import com.kdy.model.Board;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by user on 2017-03-29.
 */
public class BoardSpecification {
    public static Specification<Board> deleted(final boolean deleted){
        return new Specification<Board>() {
            @Override
            public Predicate toPredicate(Root<Board> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("deleted"),false);
            }
        };
    }
}
