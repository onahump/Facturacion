if (!session) {
	session = request.getSession(true)
}

if (!session.counter) {
	session.counter = 1
} else {
	session.counter += 1
}

if(!session.factura){
	session.factura = new Factura(emisor:session.emisor,
								  receptor:session.receptor,
								  conceptos:session.listaDeConceptos)
}

Template index = new Template()

println index.generaUnaVista("factura",[factura:session.factura])

