if (!session) {
	session = request.getSession(true)
}

//Creando un concepto y agregandolo a la lista

if (!session.listaDeConceptos) {
	session.listaDeConceptos = []
}else{
	session.listaDeConceptos
}

//Creando un emisor

if (!session.emisor) {
	session.emisor = new InvoiceEntity(razonSocial:params?.nombre_emisor,
										rfc:params.rfc_emisor)
}else{
	session.emisor
}
//Creando un receptor

if (!session.receptor) {
	session.receptor = new InvoiceEntity(razonSocial:params?.nombre_receptor,
										rfc:params.rfc_receptor)
}else{
	session.receptor
}

if(!session.concepto){
	session.concepto = new Concepto()
}else{	
	session.concepto = new Concepto(cantidad:params?.cantidad?.toInteger(),
									descripcion:params?.descripcion,
									importe:params?.importe?.toBigDecimal())
	if(session.concepto.cantidad != null && session.concepto.descripcion != null && session.concepto.descripcion != null){
	session.listaDeConceptos << session.concepto
	}
}

if(session.factura){
	session.factura = new Factura()
}else{
	session.factura
}


Template vistaConcepto = new Template()

println vistaConcepto.generaUnaVista("concepto",[:])
