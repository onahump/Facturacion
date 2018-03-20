package com.makingdevs.facturacion.model

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Column


@Entity
@Table(name = "Address")
class Address{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ADDRESS")
	Integer id

	@Column(name = "STREET")
	String street

	@Column(name = "NUM_EXTERIOR")
	String num_exterior
	
	@Column(name = "NUM_INTERIOR")
	String num_interior
	
	@Column(name = "NEIGHBORHOOD")
	String neighborhood
	
	@Column(name = "CITY")
	String city
	
	@Column(name = "STATE")
	String state 
	
	@Column(name = "COUNTRY")
	String country


}