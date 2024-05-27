package com.hexagonal.hexa.config

import com.hexagonal.hexa.adapters.`in`.consumer.message.CustomerMessage
import org.apache.kafka.clients.CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG
import org.apache.kafka.clients.CommonClientConfigs.GROUP_ID_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class KafkaConsumerConfig {

    @Bean
    fun consumerFactory(): ConsumerFactory<String, CustomerMessage> {
        val props: MutableMap<String, Any> = HashMap()
        props[BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        props[GROUP_ID_CONFIG] = "hexa"
        props[KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        props[AUTO_OFFSET_RESET_CONFIG] = "earliest"
        return DefaultKafkaConsumerFactory(
            props,
            StringDeserializer(),
            JsonDeserializer(CustomerMessage::class.java).apply {
                addTrustedPackages("*")
            }
        )
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, CustomerMessage>()
        factory.consumerFactory = consumerFactory()
        return factory
    }
}