package com.kdy.repository;

import com.kdy.model.Board;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by user on 2017-03-29.
 */
public interface BoardRepository extends JpaRepository<Board, Long>, JpaSpecificationExecutor<Board> {

    List<Board> findAll(Specification<Board> isDeleted);
}
