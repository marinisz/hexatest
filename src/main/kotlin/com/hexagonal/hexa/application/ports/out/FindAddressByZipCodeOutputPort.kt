package com.hexagonal.hexa.application.ports.out

import com.hexagonal.hexa.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun find(zipCode:String): Address?

}