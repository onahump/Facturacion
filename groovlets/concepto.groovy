if (!session) {
	session = request.getSession(true)
}

if (!session.counter) {
	session.counter = 1
} else {
	session.counter += 1
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
//Creando un concepto y agregandolo a la lista

if (!session.listaDeConceptos && !session.concepto) {
	session.listaDeConceptos = []
	session.concepto = new Concepto()
}else{
	session.concepto = new Concepto(cantidad:params?.cantidad.toInteger(),
									descripcion:params?.descripcion,
									importe:params?.importe.toInteger())
	session.listaDeConceptos << session.concepto
}

Template vistaConcepto = new Template()

println vistaConcepto.generaUnaVista("concepto",[:])
