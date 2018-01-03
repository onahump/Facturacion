class Factura{
	Date fecha = new Date()
	Emisor emisor
	Receptor receptor
	List<Concepto> conceptos = []
	Double subtotal
	Double iva
	Double total

	Double getSubtotal(){
		conceptos[0].importe + conceptos[1].importe
	}

	Double getIva(){
		subtotal * 0.16		
	}

	Double getTotal(){
		subtotal + iva
	}

}

