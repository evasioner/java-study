package com.example.study.repositories;

import com.example.study.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    @Query(value = "SELECT * FROM test WHERE MATCH (keyword) AGAINST (CONCAT('+', :query, '*') IN BOOLEAN MODE)", nativeQuery = true)
    List<Test> search(String query);
}
