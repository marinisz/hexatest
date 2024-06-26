package com.hexagonal.hexa.adapters.out.repository.mapper

import com.hexagonal.hexa.adapters.out.repository.entity.CustomerEntity
import com.hexagonal.hexa.application.core.domain.Customer
import org.mapstruct.Mapper


@Mapper(componentModel = "spring")
interface CustomerEntityMapper {
    fun toCustomerEntity(customer: Customer): CustomerEntity
    fun toCustomer(customerEntity: CustomerEntity): Customer
}