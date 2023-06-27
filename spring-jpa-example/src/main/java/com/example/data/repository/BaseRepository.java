package com.example.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * NoRepositoryBean注解指定本类不注册为bean
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T> {
}
