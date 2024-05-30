package com.hexagonal.hexa.application.core.domain

import java.util.UUID

data class Customer(var id: String? = null, val name: String, var address: Address?, val cpf: String, var isValidCpf: Boolean = false)