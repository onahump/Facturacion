class Factura{
	Date fecha = new Date()
	InvoiceEntity emisor
	InvoiceEntity receptor
	List<Concepto> conceptos = []

	String getFechaConFormato(){
		fecha.format('yyyy-dd-MM')
	}

	Double getSubtotal(){
		(conceptos[0]?.importe ?:0) + (conceptos[1]?.importe ?:0)
	}

	Double getIva(){
		subtotal * 0.16		
	}

	Double getTotal(){
		subtotal + iva
	}

}

