package com.dolezalek.belladati.skilltest.mapper;

import com.dolezalek.belladati.skilltest.dto.BankDTO;
import com.dolezalek.belladati.skilltest.entity.Bank;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BankMapper {
    BankMapper INSTANCE = Mappers.getMapper(BankMapper.class);

    BankDTO bankToBankDTO(Bank bank);

}
