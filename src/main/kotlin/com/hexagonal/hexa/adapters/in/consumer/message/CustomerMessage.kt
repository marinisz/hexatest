package com.hexagonal.hexa.adapters.`in`.consumer.message

import com.hexagonal.hexa.application.core.domain.Address

class CustomerMessage(
    var id: String,
    val name: String,
    var address: Address?,
    var zipCode: String,
    val cpf: String,
    var isValidCpf: Boolean = false
)