package com.hexagonal.hexa.application.core.usecase

import com.hexagonal.hexa.application.core.domain.Customer
import com.hexagonal.hexa.application.ports.`in`.InsertCustomerInputPort
import com.hexagonal.hexa.application.ports.out.FindAddressByZipCodeOutputPort
import com.hexagonal.hexa.application.ports.out.InsertCustomerOutputPort
import com.hexagonal.hexa.application.ports.out.SendCpfForValidationOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
) : InsertCustomerInputPort {

    @Override
    override fun insert(customer: Customer, zipCode: String) {
        val address = findAddressByZipCodeOutputPort.find(zipCode)
        customer.address = address
        insertCustomerOutputPort.insert(customer, zipCode)
        sendCpfForValidationOutputPort.send(customer.cpf)
    }
}
