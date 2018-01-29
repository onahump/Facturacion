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

println """Receptor: ${session.receptor}
		<br><br>
		Emisor: ${session.emisor}
		<br><br>"""

println params
println "<br><br>"
println context.properties
println "<br><br>"
println session?.properties
println "<br><br>"
println "Contador de sesiones: ${session.counter}"


Template vistaConcepto = new Template()

println vistaConcepto.generaUnaVista("concepto",[:])