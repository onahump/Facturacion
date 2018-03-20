package com.makingdevs.facturacion.repository

import org.springframework.data.repository.CrudRepository

import com.makingdevs.facturacion.model.Address

interface AddressRepository extends CrudRepository<Address, Long>{

}