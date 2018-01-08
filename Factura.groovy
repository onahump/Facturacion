class Factura{
	Date fecha = new Date()
	InvoiceEntity emisor
	InvoiceEntity receptor
	List<Concepto> conceptos = []

	String getFechaConFormato(){
		fecha.format('yyyy-dd-MM')
	}

	Double getSubtotal(){
		conceptos.importe.sum()
		//(conceptos[0]?.importe ?:0) + (conceptos[1]?.importe ?:0)
	}

	Double getIva(){
		subtotal * 0.16		
	}

	Double getTotal(){
		subtotal + iva
	}

	String toString(){
		"""\n
		${'*'*26} ${fechaConFormato} ${'*'*26}

		Nombre del Emisor: ${emisor}
		Nombre del Receptor: ${receptor}
		Concepto(s)
		${conceptos[0]}
		${conceptos[1]}
		${conceptos[2]?:""} 


						  Subtotal: \$ ${subtotal}
					                 Iva: \$ ${iva}
						    Total: \$ ${total}

		${'*'*65}
		"""
	}

}

