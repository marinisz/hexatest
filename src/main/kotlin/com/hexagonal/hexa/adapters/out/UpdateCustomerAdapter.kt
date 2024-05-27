package com.hexagonal.hexa.adapters.out

import com.hexagonal.hexa.adapters.out.repository.CustomerRepository
import com.hexagonal.hexa.adapters.out.repository.mapper.CustomerEntityMapper
import com.hexagonal.hexa.application.core.domain.Customer
import com.hexagonal.hexa.application.ports.out.UpdateCustomerOutputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter: UpdateCustomerOutputPort {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @Autowired
    private lateinit var customerEntityMappper: CustomerEntityMapper

    override fun update(customer: Customer) {
        var customerEntity = customerEntityMappper.toCustomerEntity(customer)
        customerRepository.save(customerEntity)
    }
}