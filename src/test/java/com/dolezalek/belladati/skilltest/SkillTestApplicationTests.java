package com.dolezalek.belladati.skilltest;

import com.dolezalek.belladati.skilltest.entity.Bank;
import com.dolezalek.belladati.skilltest.repository.BelladatiRepository;
import com.dolezalek.belladati.skilltest.service.DataLoader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SkillTestApplicationTests {

	@Autowired
	private BelladatiRepository repository;

	@Autowired
	private DataLoader dataloader;

	@Test
	void contextLoads() {
	}

	@Test
	void saveData() {
		Bank bank = new Bank ("test", "test");
		repository.save(bank);
		Optional<Bank> bank2 = repository.getById(1);
		bank2.ifPresent(value -> assertEquals(bank.getBankCode(), value.getBankCode()));
		bank2.ifPresent(value -> assertEquals(bank.getBankName(), value.getBankName()));
	}
}
