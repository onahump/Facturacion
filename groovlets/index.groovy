if (!session) {
	session = request.getSession(true)
}

Template index = new Template()

println index.generaUnaVista("index",[organizacion:"Making Devs"])
