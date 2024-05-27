package com.hexagonal.hexa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component

@EnableFeignClients
@SpringBootApplication
class HexaApplication

fun main(args: Array<String>) {
	runApplication<HexaApplication>(*args)
}
