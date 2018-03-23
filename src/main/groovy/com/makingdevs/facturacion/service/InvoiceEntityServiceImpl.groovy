package com.makingdevs.facturacion.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.makingdevs.facturacion.model.InvoiceEntity
import com.makingdevs.facturacion.repository.InvoiceEntityRepository

@Service
class InvoiceEntityServiceImpl implements InvoiceEntityService{

	@Autowired
	InvoiceEntityRepository invoiceEntityRepository

	@Override
	Iterable<InvoiceEntity> listAllInvoiceEntities(){
		invoiceEntityRepository.findAll()
	}

	@Override
	InvoiceEntity getInvoiceEntityById(Integer id){
		invoiceEntityRepository.findOne(id)
	}

	@Override
	InvoiceEntity saveInvoiceEntity(InvoiceEntity invoiceEntity){
		invoiceEntityRepository.save(invoiceEntity)
	}

	@Override
	InvoiceEntity deleteInvoiceEntity(Integer id){
		invoiceEntityRepository.delete(id)
	}

}