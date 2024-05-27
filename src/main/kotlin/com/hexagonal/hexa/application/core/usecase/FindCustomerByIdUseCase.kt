package com.hexagonal.hexa.application.core.usecase

import com.hexagonal.hexa.application.core.domain.Customer
import com.hexagonal.hexa.application.ports.`in`.FindCustomerByIdInputPort
import com.hexagonal.hexa.application.ports.out.FindCustomerByIdOutputPort


class FindCustomerByIdUseCase(private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort) :
    FindCustomerByIdInputPort {
    override fun find(id: String): Customer {
        return findCustomerByIdOutputPort.find(id)
            .orElseThrow { RuntimeException("Customer not found") }
    }
}