//iniciando la sesion pro primera vez

if (!session) {
  session = request.getSession(true)
  System.out.println session
}

//cuando la sesion
if (!session.counter) {
  session.counter = 1
} else {
	session.counter += 1
	System.out.println session.counter
}

Templates pagina = new Templates()

println pagina.generaUnTemplateParaRenderear("index")