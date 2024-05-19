package com.boombastic.mediateca.utils.repository;

import com.boombastic.mediateca.utils.models.CD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CDRepository extends JpaRepository<CD, Long> {

    Optional<CD> findById(Long aLong);
}
