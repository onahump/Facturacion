if (!session) {
	session = request.getSession(true)
}

if (session.listaDeConceptos) {
	session.listaDeConceptos = []
}

if(session.concepto){	
	session.concepto = new Concepto()
}

if (session.emisor) {
	session.emisor = null
}

if (session.receptor) {
	session.receptor = null
}

Template registro = new Template()

println registro.generaUnaVista("registro")
