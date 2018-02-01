if (!session) {
	session = request.getSession(true)
}

if (!session.listaDeObjetos) {
	session.listaDeObjetos = []
}

if (!session.factura) {
	session.factura = new Factura()
} 

Templates pagina = new Templates()

InvoiceEntity emisor = new InvoiceEntity(razonSocial:params.nombre_emisor,
					   rfc:params.rfc_emisor)

InvoiceEntity receptor = new InvoiceEntity(razonSocial:params.nombre_receptor,
					   rfc:params.rfc_receptor)

println pagina.generaUnTemplateParaRenderear("form", [listaDeObjetos: session?.listaDeObjetos, session: session])

