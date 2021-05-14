package com.example.repository;

import com.example.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People,Long> {

    Optional<People> findById(Long id);

    @Override
    List<People> findAll();
}
