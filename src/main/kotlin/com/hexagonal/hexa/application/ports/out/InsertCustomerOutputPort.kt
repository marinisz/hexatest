package com.hexagonal.hexa.application.ports.out

import com.hexagonal.hexa.application.core.domain.Customer

interface InsertCustomerOutputPort {
    fun insert(customer:Customer, zipCode: String)
}