package classes

SqlConection sql = new SqlConection()

Emisor emisor1 = new Emisor(razonSocial:"LA EUROPEA MEXICO, S.A.P.I DE C.V.",rfc:"EME910610G1A",direccion:direccion.direccionEmisor.darDireccion())
Direccion direccionEmisor = new Direccion(calle:"Rodolfo Gaona", noExterior:"86",noInterior:"E",cPostal:"11200",colonia:"El Carmen", estado:"CDMX",municipio:"Coyoacan",pais:"México")

Receptor receptor1 = new Receptor(razonSocial:"LA EUROPEA MEXICO, S.A.P.I DE C.V.",rfc:"EME910610G1A",direccion:direccion.direccionReceptor.darDireccion())
Direccion direccionReceptor = new Direccion(calle:"Calzada Ermita Iztapalapa", noExterior:"278",noInterior:"501",cPostal:"09470",colonia:"Sinatel", estado:"CDMX",municipio:"Iztapalapa",pais:"México")


Concepto concepto1 = new Concepto(cantidad:1, descripcion:"Cocacola 135ml",importe:15.93)
Concepto concepto2 = new Concepto(cantidad:2, descripcion:"Chetos",importe:10.20)
def listaDeConceptos = [concepto1,concepto2]
def getSubtotal(listaDeConceptos)


println receptor1