package com.hexagonal.hexa.adapters.out.repository.entity

import com.hexagonal.hexa.application.core.domain.Address
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "customers")
data class CustomerEntity(@Id val id: String, val name: String, var addressEntity: Address?, val cpf: String, var isValidCpf: Boolean)