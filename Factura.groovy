class Factura{
	Date fecha = new Date()
	InvoiceEntity emisor
	InvoiceEntity receptor
	List<Concepto> conceptos = []


	String getFechaConFormato(){
		fecha.format('yyyy-dd-MM')
	}

	BigDecimal getSubtotal(){
		conceptos.importe.sum()
		//(conceptos[0]?.importe ?:0) + (conceptos[1]?.importe ?:0)
	}

	BigDecimal getIva(){
		subtotal * 0.16	 	
	}

	BigDecimal getTotal(){
		subtotal + iva
	}

	String toString(){
		"""\n
		${'*'*26} ${fechaConFormato} ${'*'*26}<br>

		Nombre del Emisor: ${emisor}<br>
		Nombre del Receptor: ${receptor}<br>
		Concepto(s)<br>
		${conceptos[0]?:""}<br>
		${conceptos[1]?:""}<br>
		${conceptos[2]?:""}<br>
		${conceptos[3]?:""}<br>
		${conceptos[4]?:""}<br>
		${conceptos[5]?:""}<br>
		${conceptos[6]?:""}<br>
		${conceptos[7]?:""}<br>
		${conceptos[8]?:""}<br>
		${conceptos[9]?:""}<br>
		${conceptos[10]?:""} <br>


						  	Subtotal: \$ ${subtotal}<br>
					               	Iva: \$ ${iva}<br>
						     	Total: \$ ${total}<br>

		${'*'*65}
		"""
	}

}

