package com.boombastic.mediateca.utils.repository;

import com.boombastic.mediateca.utils.models.Tesis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TesisRepository extends JpaRepository<Tesis, Long> {

    Optional<Tesis> findById(Long aLong);
}
