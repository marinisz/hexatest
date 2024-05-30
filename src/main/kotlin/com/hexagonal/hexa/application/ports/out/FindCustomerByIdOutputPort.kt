package com.hexagonal.hexa.application.ports.out

import com.hexagonal.hexa.application.core.domain.Customer
import java.util.Optional

interface FindCustomerByIdOutputPort {
    fun find(uuid: String?): Optional<Customer>
}