package com.hexagonal.hexa.adapters.out

import com.hexagonal.hexa.adapters.out.repository.CustomerRepository
import com.hexagonal.hexa.adapters.out.repository.mapper.CustomerEntityMapper
import com.hexagonal.hexa.application.core.domain.Customer
import com.hexagonal.hexa.application.ports.out.InsertCustomerOutputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter : InsertCustomerOutputPort{

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @Autowired
    private lateinit var customerEntityMapper: CustomerEntityMapper

    override fun insert(customer: Customer, zipCode: String) {
        customerRepository.save(customerEntityMapper.toCustomerEntity(customer))
    }
}