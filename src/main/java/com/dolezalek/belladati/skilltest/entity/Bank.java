package com.dolezalek.belladati.skilltest.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    long id;

    String bankName;

    String bankCode;

    public Bank(String bankName, String bankCode) {
        this.bankName = bankName;
        this.bankCode = bankCode;
    }
}
