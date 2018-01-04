//Direcciones

Direccion direccionDelEmisor = new Direccion(
	calle:"Rodolfo Gaona", 
	noExterior:"86",
	noInterior:"E",
	cPostal:"11200",
	colonia:"El Carmen", 
	estado:"CDMX",
	municipio:"Coyoacan",
	pais:"México")

Direccion direccionDelReceptor = new Direccion(
	calle:"Calzada Ermita Iztapalapa",
	noExterior:"278",
	noInterior:"501",
	cPostal:"09470",
	colonia:"Sinatel",
	estado:"CDMX",
	municipio:"Iztapalapa",
	pais:"México")

//Emisor

Emisor emisor = new Emisor(razonSocial:"LA EUROPEA MEXICO, S.A.P.I DE C.V.",
						   rfc:"EME910610G1A")
emisor.direccion = direccionDelEmisor

//Receptor

Receptor receptor = new Receptor(razonSocial:"MAKING DEVS",
								 rfc:"EME910610G1A")
receptor.direccion = direccionDelReceptor

//Conceptos 

Concepto concepto1 = new Concepto(cantidad:1, 
								  descripcion:"Coca-cola 135ml",
								  importe:372.267241)
Concepto concepto2 = new Concepto(cantidad:2, 
								  descripcion:"Chetos",
								  importe:249.301724)    

def listaDeConceptos = [concepto1,concepto2]

//Instanciando la factura numero 1 y agregando elementos a sus atributos"
Factura factura1 = new Factura(
							   emisor:emisor, 
							   receptor:receptor, 
							   conceptos:listaDeConceptos)
//Imprimiendo la factura

println factura1

//ContadorPublico yarey = new ContadorPublico()
//Factura factura2 = yarey.quieroLaFacturaConIdentificador(50)


//println factura2
//println new Factura()