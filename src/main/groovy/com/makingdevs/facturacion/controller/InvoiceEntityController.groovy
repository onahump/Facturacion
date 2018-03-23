package com.makingdevs.facturacion.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import com.makingdevs.facturacion.service.InvoiceEntityService
import com.makingdevs.facturacion.model.Address
import com.makingdevs.facturacion.model.InvoiceEntity

@Controller
class InvoiceEntityController{

	@Autowired
	AddressService addressService
	
	@Autowired
	InvoiceEntityService invoiceEntityService 
	
	@RequestMapping("InvoiceEntity/new")
    String newInvoiceEntity(Model model){
    	model.addAttribute("invoiceEntity",address:new Address(),
    					   invoiceEntity:new InvoiceEntity())
    	"invoiceEntityForm"
    }

	@RequestMapping("invoiceEntity/{id}", method= RequestMethod.GET)
	String showInovoiceEntity(Model model){
		model.addAttribute("invoiceEntity", invoiceEntityService.getInvoiceEntityById())
		"showInovoiceEntity"	
	}
    @RequestMapping()

}