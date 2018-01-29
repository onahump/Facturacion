if (!session) {
	session = request.getSession(true)
}

if (!session.counter) {
	session.counter = 1
} else {
	session.counter += 1
}


println params
println "<br><br>"
println context.properties
println "<br><br>"
println session?.properties
println "<br><br>"
println "Contador de sesiones: ${session.counter}"

Template registro = new Template()

println registro.generaUnaVista("registro")