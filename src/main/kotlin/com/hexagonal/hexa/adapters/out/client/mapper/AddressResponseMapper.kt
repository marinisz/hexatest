package com.hexagonal.hexa.adapters.out.client.mapper
import com.hexagonal.hexa.adapters.out.client.response.AddressResponse
import com.hexagonal.hexa.application.core.domain.Address
import org.mapstruct.Mapper
import org.springframework.stereotype.Component


@Component
@Mapper(componentModel = "spring")
interface AddressResponseMapper {
    fun toAddress(addressResponse: AddressResponse): Address;
}