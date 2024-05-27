package com.hexagonal.hexa.adapters.out

import com.hexagonal.hexa.adapters.out.client.FindAddressByZipCodeClient
import com.hexagonal.hexa.adapters.out.client.mapper.AddressResponseMapper
import com.hexagonal.hexa.application.core.domain.Address
import com.hexagonal.hexa.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter() : FindAddressByZipCodeOutputPort{

    @Autowired
    private lateinit var findAddressByZipCodeClient: FindAddressByZipCodeClient

    @Autowired
    private lateinit var addressResponseMapper: AddressResponseMapper

    override fun find(zipCode: String): Address? {
        var addressResponse = findAddressByZipCodeClient.find(zipCode)
        return addressResponseMapper.toAddress(addressResponse)
    }
}