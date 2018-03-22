package com.makingdevs.facturacion.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.makingdevs.facturacion.model.Address
import com.makingdevs.facturacion.repository.AddressRepository

@Service
class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressRepository addressRepository

	Iterable<Address> listAllAddresses(){
		addressRepository.findAll()
	}

	@Override
	Address getAddressById(Integer id){
		addressRepository.findOne(id)
	}

	@Override
	Address saveAddress(Address address){
		addressRepository.save(address)
	}

	@Override
	Address deleteAddress(Integer id){
		addressRepository.delete(id)
	}



}