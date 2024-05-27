package com.hexagonal.hexa.application.ports.`in`

import com.hexagonal.hexa.application.core.domain.Customer

interface InsertCustomerInputPort {
    fun insert(customer: Customer, zipCode: String)
}