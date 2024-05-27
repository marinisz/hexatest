package com.arantes.hexagonal.application.core.usecase

import com.hexagonal.hexa.application.core.domain.Customer
import com.hexagonal.hexa.application.ports.`in`.FindCustomerByIdInputPort
import com.hexagonal.hexa.application.ports.`in`.UpdateCustomerInputPort
import com.hexagonal.hexa.application.ports.out.FindAddressByZipCodeOutputPort
import com.hexagonal.hexa.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(
    findCustomerByIdInputPort: FindCustomerByIdInputPort,
    findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    updateCustomerOutputPort: UpdateCustomerOutputPort
) : UpdateCustomerInputPort {
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort
    private val updateCustomerOutputPort: UpdateCustomerOutputPort

    init {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort
        this.updateCustomerOutputPort = updateCustomerOutputPort
    }

    override fun update(customer: Customer, zipCode: String) {
        findCustomerByIdInputPort.find(customer.id)
        val address = findAddressByZipCodeOutputPort.find(zipCode)
        customer.address = address
        updateCustomerOutputPort.update(customer)
    }
}