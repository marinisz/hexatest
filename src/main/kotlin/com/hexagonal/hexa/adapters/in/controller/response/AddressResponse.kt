package com.hexagonal.hexa.adapters.`in`.controller.response

import com.hexagonal.hexa.application.core.domain.Address
import java.util.*

class AddressResponse(val id: String, val name: String, var address: Address?, val cpf: String, var isValidCpf: Boolean = false)