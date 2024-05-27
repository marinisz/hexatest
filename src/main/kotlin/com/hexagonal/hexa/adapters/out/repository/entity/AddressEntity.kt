package com.hexagonal.hexa.adapters.out.repository.entity

import org.springframework.data.mongodb.core.mapping.Document

class AddressEntity(val street: String, val city: String, val state:String)