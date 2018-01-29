if (!session) {
	session = request.getSession(true)
}

if (!session.counter) {
	session.counter = 1
} else {
	session.counter += 1
}

Template index = new Template()

println index.generaUnaVista("factura")
