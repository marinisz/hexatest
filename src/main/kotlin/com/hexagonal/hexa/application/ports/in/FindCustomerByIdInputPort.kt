package com.hexagonal.hexa.application.ports.`in`

import com.hexagonal.hexa.application.core.domain.Customer

interface FindCustomerByIdInputPort {
    fun find(id: String?):Customer
}