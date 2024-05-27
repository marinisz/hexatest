package com.hexagonal.hexa.application.ports.out

interface SendCpfForValidationOutputPort {

    fun send(cpf: String)

}