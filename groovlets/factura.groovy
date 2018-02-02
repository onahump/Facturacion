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

							//Llamando a yarey 
//ContadorPublico yarey = new ContadorPublico()
//Yarey verifica que existan las tablas en la base de datos 
//yarey.verificaSiLasTablasExisten()
//Yarey por favor registra la factura.
//yarey.registraLaFactura(session.factura)

session.factura = null
session.receptor = null
session.listaDeConceptos = null
session.receptor = null
session.concepto = null

