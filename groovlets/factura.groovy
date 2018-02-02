if (!session) {
	session = request.getSession(true)
}

if(!session.factura){
	session.factura = new Factura(emisor:session.emisor,
								  receptor:session.receptor,
								  conceptos:session.listaDeConceptos)
}else{
	session.factura = new Factura(emisor:session.emisor,
								  receptor:session.receptor,
								  conceptos:session.listaDeConceptos)
}

Template index = new Template()

println index.generaUnaVista("factura",[factura:session.factura])

