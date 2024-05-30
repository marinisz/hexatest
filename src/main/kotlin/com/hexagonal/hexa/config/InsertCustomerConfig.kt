package com.hexagonal.hexa.config

import com.hexagonal.hexa.adapters.out.FindAddressByZipCodeAdapter
import com.hexagonal.hexa.adapters.out.InsertCustomerAdapter
import com.hexagonal.hexa.adapters.out.SendCpfValidationAdapter
import com.hexagonal.hexa.application.core.usecase.InsertCustomerUseCase
import com.hexagonal.hexa.application.ports.`in`.InsertCustomerInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {
    @Bean
    fun insertCustomerUseCase(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter,
        sendCpfValidationAdapter: SendCpfValidationAdapter
    ): InsertCustomerUseCase {
        return InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter)
    }

}