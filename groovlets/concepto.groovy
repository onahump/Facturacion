if (!session) {
  session = request.getSession(true)
}

if (!session.counter) {
  session.counter = 1
} else {
	session.counter += 1
}

Templates pagina = new Templates()

def listaDeConceptos = []

	Concepto concepto = new Concepto(cantidad:params.cantidad.toInteger(),
									  descripcion:params.descripcion,
									  importe:params.importe.toBigDecimal())

	listaDeConceptos << concepto

System.out.println(listaDeConceptos)

println pagina.generaUnTemplateParaRenderear("concepto")

