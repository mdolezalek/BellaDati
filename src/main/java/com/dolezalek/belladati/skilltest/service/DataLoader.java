package com.dolezalek.belladati.skilltest.service;

import com.belladati.sdk.BellaDati;
import com.belladati.sdk.BellaDatiService;
import com.belladati.sdk.report.ReportInfo;
import com.belladati.sdk.util.PaginatedList;
import com.dolezalek.belladati.skilltest.entity.Bank;
import com.dolezalek.belladati.skilltest.repository.BelladatiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DataLoader implements ApplicationRunner {

    @Value("${belladati.key}")
    String key;
    @Value("${belladati.secret}")
    String secret;
    @Value("${belladati.user}")
    String user;
    @Value("${belladati.password}")
    String password;

    private BelladatiRepository repository;

    @Autowired
    public DataLoader(BelladatiRepository repository) {
        this.repository = repository;
    }

    public void run(ApplicationArguments args) {
        BellaDatiService service = BellaDati.connectInsecure("https://service.belladati.com").xAuth(key, secret, user, password);

        List<ReportInfo> reports = Collections.unmodifiableList((List<ReportInfo>) service.getReportInfo().load());
        if (!reports.isEmpty()) {
            for (ReportInfo report : reports) {
                Bank bank = (Bank) report;
                repository.save(bank);
            }
        }
    }
}
