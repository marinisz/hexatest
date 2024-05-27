package com.hexagonal.hexa.adapters.`in`.controller.response

import com.hexagonal.hexa.application.core.domain.Address
import java.util.*

class CustomerResponse(val name: String, var address: Address?, val cpf: String, var isValidCpf: Boolean = false)