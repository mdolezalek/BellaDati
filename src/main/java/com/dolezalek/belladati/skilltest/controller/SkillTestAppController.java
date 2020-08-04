package com.dolezalek.belladati.skilltest.controller;

import com.dolezalek.belladati.skilltest.entity.Bank;
import com.dolezalek.belladati.skilltest.exception.BankNotFoundException;
import com.dolezalek.belladati.skilltest.repository.BelladatiRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SkillTestAppController {

    private final BelladatiRepository repository;

    @GetMapping("/banks")
    public List<Bank> all() {
        return repository.findAll();
    }

    @PostMapping("/banks")
    public Bank newBank(@RequestBody Bank newRecord) {
        return repository.save(newRecord);
    }

    @GetMapping("/banks/{id}")
    public Bank uno(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BankNotFoundException(id));
    }

}
