package com.hexagonal.hexa.adapters.`in`.controller.mapper

import com.hexagonal.hexa.adapters.`in`.controller.request.CustomerRequest
import com.hexagonal.hexa.adapters.`in`.controller.response.CustomerResponse
import com.hexagonal.hexa.application.core.domain.Customer
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    fun toCustomer(customerRequest: CustomerRequest): Customer

    fun toCustomerResponse(customer: Customer):CustomerResponse
}