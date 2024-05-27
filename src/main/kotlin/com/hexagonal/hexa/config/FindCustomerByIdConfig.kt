package com.hexagonal.hexa.config

import com.hexagonal.hexa.adapters.out.FindCustomerByIdAdapter
import com.hexagonal.hexa.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FindCustomerByIdConfig {
    @Bean
    fun findCustomerByIdUseCase(
        findCustomerByIdAdapter: FindCustomerByIdAdapter?
    ): FindCustomerByIdUseCase {
        return FindCustomerByIdUseCase(findCustomerByIdAdapter!!)
    }
}