package com.dolezalek.belladati.skilltest.repository;

import com.dolezalek.belladati.skilltest.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BelladatiRepository extends JpaRepository<Bank, Long> {

    Optional<Bank> getById(long id);

}
