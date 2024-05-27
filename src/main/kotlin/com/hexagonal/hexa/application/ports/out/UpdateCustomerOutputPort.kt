package com.hexagonal.hexa.application.ports.out

import com.hexagonal.hexa.application.core.domain.Customer

interface UpdateCustomerOutputPort {

    fun update(customer: Customer);

}