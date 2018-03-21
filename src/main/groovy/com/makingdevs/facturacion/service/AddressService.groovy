package com.makingdevs.facturacion.service

import com.makingdevs.facturacion.model.Address

interface AddressService{

	Iterable<Address> listAllAddresses()
	
	Address getAddressById(Integer id)
	
	Address saveAddress(Address address)
	
	Address deleteAddress(Integer id)

} 