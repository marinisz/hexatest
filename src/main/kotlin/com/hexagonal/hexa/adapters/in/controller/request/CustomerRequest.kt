package com.hexagonal.hexa.adapters.`in`.controller.request

import jakarta.validation.constraints.NotBlank

class CustomerRequest(
    @NotBlank
    var name: String,
    @NotBlank
    var cpf: String,
    @NotBlank
    var zipCode: String) {
}