//println "<br><br>"
//println request.properties
//println "<br><br>"
//println headers
//println "<br><br>"
//println params
//println "<br><br>"
//println context.properties
//println "<br><br>"
//println session?.properties
//println "<br><br>"
//response.status = 201
//response.addHeader("tokenazo", "21798126")
//println response.properties

persona = new Persona(nombre:"Juan", apellidos:"Zuñiga")
t = new Templates()
r = t.generaUnTemplateParaRenderear("hello", [persona:persona])
println r

