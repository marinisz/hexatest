package com.hexagonal.hexa.adapters.out

import com.hexagonal.hexa.adapters.out.repository.CustomerRepository
import com.hexagonal.hexa.adapters.out.repository.entity.CustomerEntity
import com.hexagonal.hexa.adapters.out.repository.mapper.CustomerEntityMapper
import com.hexagonal.hexa.application.core.domain.Customer
import com.hexagonal.hexa.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class FindCustomerByIdAdapter() : FindCustomerByIdOutputPort{

    @Autowired
    private lateinit var customerEntityMapper: CustomerEntityMapper

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    override fun find(uuid: String): Optional<Customer> {
        val customerEntity = customerRepository.findByCustomerId(uuid)
        return customerEntity.map { entity ->
            customerEntityMapper.toCustomer(entity)
        }
    }
}