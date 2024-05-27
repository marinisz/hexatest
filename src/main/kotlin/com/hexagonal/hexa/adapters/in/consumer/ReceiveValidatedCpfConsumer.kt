package com.hexagonal.hexa.adapters.`in`.consumer

import com.hexagonal.hexa.adapters.`in`.consumer.mapper.CustomerMessageMapper
import com.hexagonal.hexa.adapters.`in`.consumer.message.CustomerMessage
import com.hexagonal.hexa.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveValidatedCpfConsumer() {

    @Autowired
    private lateinit var updateCustomerInputPort: UpdateCustomerInputPort

    @Autowired
    private lateinit var customerMessageMapper: CustomerMessageMapper

    @KafkaListener(topics = ["tp-cpf-validated"], groupId = "hexa")
    fun receive(customerMessage: CustomerMessage){
        var customer = customerMessageMapper.toCustomer(customerMessage)
        updateCustomerInputPort.update(customer, customerMessage.zipCode)
    }

}