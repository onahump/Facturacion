package com.makingdevs.facturacion.service

import com.makingdevs.facturacion.model.InvoiceEntity

interface InvoiceEntityService{

	Iterable<InvoiceEntity> listAllInvoiceEntities()

	InvoiceEntity getInvoiceEntityById(Integer id)

	InvoiceEntity saveInvoiceEntity(InvoiceEntity invoiceEntity)

	InvoiceEntity deleteInvoiceEntity(Integer id)


}