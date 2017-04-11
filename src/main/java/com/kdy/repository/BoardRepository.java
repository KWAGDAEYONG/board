package com.kdy.repository;

import com.kdy.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 2017-03-29.
 */
public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryQueryDsl {
 
}
