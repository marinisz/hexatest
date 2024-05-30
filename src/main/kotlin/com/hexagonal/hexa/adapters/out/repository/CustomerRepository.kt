package com.hexagonal.hexa.adapters.out.repository

import com.hexagonal.hexa.adapters.out.repository.entity.CustomerEntity
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface CustomerRepository : MongoRepository<CustomerEntity, String> {
    fun findById(id: String?): Optional<CustomerEntity>
}