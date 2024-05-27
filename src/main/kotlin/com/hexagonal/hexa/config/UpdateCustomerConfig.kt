package com.hexagonal.hexa.config

import com.arantes.hexagonal.application.core.usecase.UpdateCustomerUseCase
import com.hexagonal.hexa.adapters.out.FindAddressByZipCodeAdapter
import com.hexagonal.hexa.adapters.out.UpdateCustomerAdapter
import com.hexagonal.hexa.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class UpdateCustomerConfig {
    @Bean
    fun updateCustomerUseCase(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter
    ): UpdateCustomerUseCase {
        return UpdateCustomerUseCase(
            findCustomerByIdUseCase!!, findAddressByZipCodeAdapter!!,
            updateCustomerAdapter!!
        )
    }
}