package com.mehmetpekldemir.tdd.repository;

import com.mehmetpekldemir.tdd.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
