

Templates pagina = new Templates()
	
	Concepto concepto = new Concepto(cantidad:params.cantidad.toInteger(),
									  descripcion:params.descripcion,
									  importe:params.importe.toBigDecimal())

	
	System.out.println(concepto)

println pagina.generaUnTemplateParaRenderear("concepto")

