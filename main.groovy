package classes

import java.sql.*
@Grab('mysql:mysql-connector-java:5.1.25')
@GrabConfig(systemClassLoader = true)
import groovy.sql.Sql


SqlConection sql = SqlConection.getInstance()

Direccion direccionEmisor = new Direccion(calle:"Rodolfo Gaona", noExterior:"86",noInterior:"E",cPostal:"11200",colonia:"El Carmen", estado:"CDMX",municipio:"Coyoacan",pais:"México")
Emisor emisor1 = new Emisor(razonSocial:"LA EUROPEA MEXICO, S.A.P.I DE C.V.",rfc:"EME910610G1A")
emisor1.direccion = direccionEmisor.darDireccion()

Direccion direccionReceptor = new Direccion(calle:"Calzada Ermita Iztapalapa", noExterior:"278",noInterior:"501",cPostal:"09470",colonia:"Sinatel", estado:"CDMX",municipio:"Iztapalapa",pais:"México")
Receptor receptor1 = new Receptor(razonSocial:"MAKING DEVS",rfc:"EME910610G1A")
receptor1.direccion = direccionReceptor.darDireccion()

Concepto concepto1 = new Concepto(cantidad:1, descripcion:"Coca-cola 135ml",importe:372.267241)
Concepto concepto2 = new Concepto(cantidad:2, descripcion:"Chetos",importe:249.301724)    
def listaDeConceptos = [concepto1,concepto2]


Factura factura1 = new Factura(
							   nombreDelEmisor:emisor1.razonSocial, 
							   nombreDelReceptor:receptor1.razonSocial, 
							   concepto:listaDeConceptos)
factura1.subtotal = factura1.getSubtotal()
factura1.iva = factura1.getIva()
factura1.total = factura1.getTotal()

println "*"*25 + "FACTURA" + "*"*25
println "Nombre del Emisor: ${factura1.nombreDelEmisor}"

sql.consultTable()

