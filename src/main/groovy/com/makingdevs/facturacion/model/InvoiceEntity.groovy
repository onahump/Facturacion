package com.makingdevs.facturacion.model

import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.CascadeType
import javax.persistence.FetchType
import javax.persistence.OneToOne
import javax.persistence.JoinColumn


@Entity
@Table(name="INVOICE_ENTITY")
class InvoiceEntity{
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="ID_INVOICE_ENTITY")
	Interger id

	@Column(name="BUSSISNESS_NAME")
	String bussisnesName
	
	@Column(name="RFC")
	String rfc

	@OneToOne( cascade = CascadeType.ALL, fetch= FetchType.EAGER)
  	@JoinColumn(name="ADDRESS_ID")
	Address address
}