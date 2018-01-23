Templates pagina = new Templates()

	InvoiceEntity emisor = new InvoiceEntity(razonSocial:params.nombre_emisor,
							   rfc:params.rfc_emisor)

	InvoiceEntity receptor = new InvoiceEntity(razonSocial:params.nombre_receptor,
							   rfc:params.rfc_receptor)

	Concepto concepto1 = new Concepto(cantidad:1, 
									  descripcion:"Tachas 100g",
									  importe:25.56)
	Concepto concepto2 = new Concepto(cantidad:1, 
									  descripcion:"Coca-ina 250g",
									  importe:100.50)   

	def listaDeConceptosFactura = [concepto1,concepto2]

	Factura factura = new Factura(emisor:emisor, 
								   receptor:receptor, 
								   conceptos:listaDeConceptosFactura)

	System.out.println(factura)

println pagina.generaUnTemplateParaRenderear("form")

