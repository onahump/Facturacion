class Factura{
	Date fecha = new Date()
	Emisor emisor
	Receptor receptor
	List<Concepto> conceptos = []

	Double getSubtotal(){
		(conceptos[0]?.importe ?:0) + (conceptos[1]?.importe ?:0)
	}

	Double getIva(){
		subtotal * 0.16		
	}

	Double getTotal(){
		subtotal + iva
	}

	String toString(){
		"""\

		${'*'*26} ${fecha.format('dd/MM/yyyy')} ${'*'*26}

		Nombre del Emisor: ${emisor}
		Nombre del Receptor: ${receptor}
		Concepto(s)
		${conceptos[0]}
		${conceptos[1]}

						  Subtotal: \$ ${subtotal}
					                 Iva: \$ ${iva}
						    Total: \$ ${total}

		${'*'*52}
		"""
	}

}

