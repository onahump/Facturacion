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

Template vistaConcepto = new Template()

println vistaConcepto.generaUnaVista("concepto",[:])