package com.boombastic.mediateca.utils.repository;
import com.boombastic.mediateca.utils.models.DVD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DVDRepository extends JpaRepository<DVD, Long> {

    Optional<DVD> findById(Long aLong);
}
