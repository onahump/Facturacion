listaDeFacturas = []

Direccion direccionEmisor = new Direccion(
	calle:"Rodolfo Gaona", 
	noExterior:"86",
	noInterior:"E",
	cPostal:"11200",
	colonia:"El Carmen", 
	estado:"CDMX",
	municipio:"Coyoacan",
	pais:"México")
Emisor emisor1 = new Emisor(razonSocial:"LA EUROPEA MEXICO, S.A.P.I DE C.V.",rfc:"EME910610G1A")
emisor1.direccion = direccionEmisor

Direccion direccionReceptor = new Direccion(
	calle:"Calzada Ermita Iztapalapa",
	noExterior:"278",
	noInterior:"501",
	cPostal:"09470",
	colonia:"Sinatel",
	estado:"CDMX",
	municipio:"Iztapalapa",
	pais:"México")
Receptor receptor1 = new Receptor(razonSocial:"MAKING DEVS",
	rfc:"EME910610G1A")
receptor1.direccion = direccionReceptor

Concepto concepto1 = new Concepto(cantidad:1, descripcion:"Coca-cola 135ml",importe:372.267241)
Concepto concepto2 = new Concepto(cantidad:2, descripcion:"Chetos",importe:249.301724)    
def listaDeConceptos = [concepto1,concepto2]

//Instanciando la factura numero 1 y agregando elementos a sus atributos"
Factura factura1 = new Factura(
							   emisor:emisor1, 
							   receptor:receptor1, 
							   conceptos:listaDeConceptos)
factura1.subtotal = factura1.subtotal
factura1.iva = factura1.iva
factura1.total = factura1.total


//Imprimiendo la factura
s = """\

${'*'*26} FACTURA ${'*'*26}

Nombre del Emisor: ${factura1.emisor}
Nombre del Receptor: ${factura1.receptor}
Concepto(s)
Cantidad: ${factura1.conceptos[0].cantidad}  Descripcion: ${factura1.conceptos[0].descripcion} Importe: ${factura1.conceptos[0].importe}
Cantidad: ${factura1.conceptos[1].cantidad}  Descripcion: ${factura1.conceptos[1].descripcion} 	  Importe: ${factura1.conceptos[1].importe}

				  Subtotal: \$ ${factura1.subtotal}
			                 Iva: \$ ${factura1.iva}
				    Total: \$ ${factura1.total}

${'*'*52}
"""
println s

