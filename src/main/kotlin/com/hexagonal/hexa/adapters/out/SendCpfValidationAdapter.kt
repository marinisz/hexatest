package com.hexagonal.hexa.adapters.out

import com.hexagonal.hexa.application.ports.out.SendCpfForValidationOutputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class SendCpfValidationAdapter: SendCpfForValidationOutputPort {

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, String>

    override fun send(cpf: String) {
        kafkaTemplate.send("tp-cpf-validation", cpf)
    }
}