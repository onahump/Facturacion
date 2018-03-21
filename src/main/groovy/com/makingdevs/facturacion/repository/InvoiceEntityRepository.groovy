package com.makingdevs.facturacion.repository

import org.springframework.data.repository.CrudRepository

import com.makingdevs.facturacion.model.InvoiceEntity

interface InvoiceEntityRepository extends CrudRepository<InvoiceEntity, Long>{

}