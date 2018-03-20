package com.makingdevs.facturacion.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.makingdevs.facturacion.model.Address
import com.makingdevs.facturacion.repository.AddressRepository

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressRepository addressRepository

	public Iterable<Address> listAllAddresses(){
		addressRepository.findAll()
	}

	@Override
	public Address getAddressById(Integer id){
		addressRepository.findOne(id)
	}

	@Override
	public Address saveAddress(Address address){
		addressRepository.save(address)
	}

	@Override
	public Address deleteAddress(Integer id){
		addressRepository.delete(id)
	}



}