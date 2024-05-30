package com.hexagonal.hexa.adapters.`in`.controller

import com.hexagonal.hexa.adapters.`in`.controller.mapper.CustomerMapper
import com.hexagonal.hexa.adapters.`in`.controller.request.CustomerRequest
import com.hexagonal.hexa.adapters.`in`.controller.response.CustomerResponse
import com.hexagonal.hexa.application.ports.`in`.FindCustomerByIdInputPort
import com.hexagonal.hexa.application.ports.`in`.InsertCustomerInputPort
import com.hexagonal.hexa.application.ports.`in`.UpdateCustomerInputPort
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController {

    @Autowired
    private lateinit var insertCustomerInputPort: InsertCustomerInputPort

    @Autowired
    private lateinit var findCustomerByIdInputPort: FindCustomerByIdInputPort

    @Autowired
    private lateinit var updateCustomerInputPort: UpdateCustomerInputPort

    @Autowired
    private lateinit var customerMapper: CustomerMapper

    @PostMapping
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest) : ResponseEntity<Void>{
        var customer = customerMapper.toCustomer(customerRequest)
        insertCustomerInputPort.insert(customer, customerRequest.zipCode)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id:String):ResponseEntity<CustomerResponse> {
        var customer = findCustomerByIdInputPort.find(id)
        var customerResponse = customerMapper.toCustomerResponse(customer)
        return ResponseEntity.ok().body(customerResponse)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id:String, @Valid @RequestBody customerRequest: CustomerRequest): ResponseEntity<Void>{
        var customer = customerMapper.toCustomer(customerRequest)
        customer.id = id
        updateCustomerInputPort.update(customer, customerRequest.zipCode)
        return ResponseEntity.noContent().build()
    }
}