package com.hexagonal.hexa.application.ports.`in`

import com.hexagonal.hexa.application.core.domain.Customer

interface UpdateCustomerInputPort {
    fun update(customer: Customer, zipCode: String){}
}