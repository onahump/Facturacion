package classes

class Factura{
	Date fecha = new Date()
	String nombreDelEmisor
	String nombreDelReceptor
	List<Concepto> concepto = []
	Double subtotal
	Double iva
	Double total

	Double getSubtotal(){
		concepto[0].importe + concepto[1].importe
	}

	Double getIva(){
		subtotal * 0.16		
	}

	Double getTotal(){
		subtotal + iva
	}

}

