if (!session) {
	session = request.getSession(true)
}

if (!session.counter) {
	session.counter = 1
} else {
	session.counter += 1
}
println "<br><br>"
println request.properties
println "<br><br>"
println headers
println "<br><br>"
println params
println "<br><br>"
println context.properties
println "<br><br>"
println session?.properties
println "<br><br>"
response.status = 201
response.addHeader("tokenazo", "21798126")
println response.properties
println "<br><br>"
println headers
println "<br><br>"
println "Contador de sesiones: ${session.counter}"


Template index = new Template()

println index.generaUnaVista("index",[organizacion:"Making Devs"])
