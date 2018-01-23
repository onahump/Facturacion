if (!session) {
	session = request.getSession(true)
}

if (!session.counter) {
	session.counter = 1
} else {
	session.counter += 1
}

if (!session.listaDeObjetos) {
	session.listaDeObjetos = []
}

if (!session.factura) {
	session.factura = new Factura()
} 

session.listaDeObjetos += ["Hola ${session.listaDeObjetos.size()}"]
System.out.println("Hello lista")


Templates pagina = new Templates()

InvoiceEntity emisor = new InvoiceEntity(razonSocial:params.nombre_emisor,
					   rfc:params.rfc_emisor)

InvoiceEntity receptor = new InvoiceEntity(razonSocial:params.nombre_receptor,
					   rfc:params.rfc_receptor)

//System.out.println(emisor)



println pagina.generaUnTemplateParaRenderear("form", [listaDeObjetos: session?.listaDeObjetos, session: session])

