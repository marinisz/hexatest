package com.hexagonal.hexa.config

import org.apache.kafka.clients.CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG
import org.apache.kafka.clients.CommonClientConfigs.GROUP_ID_CONFIG
import org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG
import org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import java.util.HashMap;

@Configuration
class KafkaProducerConfig {

    @Bean
    fun producerFactory(): ProducerFactory<String, String> {
        val configProps: MutableMap<String, Any> = HashMap()
        configProps[BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        configProps[GROUP_ID_CONFIG] = "hexa"
        configProps[KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configProps[VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        return DefaultKafkaProducerFactory(configProps)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {
        return KafkaTemplate(producerFactory())
    }
}