package me.mhlee.mentoring.mentoring.common;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService {
    @Autowired
    private EntityManager em;

    protected JPAQueryFactory query() {
        return new JPAQueryFactory(em);
    }

    protected BooleanBuilder where() {
        return new BooleanBuilder();
    }
}