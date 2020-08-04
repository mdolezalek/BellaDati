package com.dolezalek.belladati.skilltest.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDTO {

    private long id;

    private String bankName;

    private String bankCode;
}
