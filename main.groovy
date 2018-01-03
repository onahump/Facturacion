import java.sql.*
@Grab('mysql:mysql-connector-java:5.1.25')
@GrabConfig(systemClassLoader = true)
import groovy.sql.Sql

listaDeFacturas = []
SqlConection sql = SqlConection.getInstance() //Estableciendo conecion con la base de datos

Direccion direccionEmisor = new Direccion(calle:"Rodolfo Gaona", noExterior:"86",noInterior:"E",cPostal:"11200",colonia:"El Carmen", estado:"CDMX",municipio:"Coyoacan",pais:"México")
Emisor emisor1 = new Emisor(razonSocial:"LA EUROPEA MEXICO, S.A.P.I DE C.V.",rfc:"EME910610G1A")
emisor1.direccion = direccionEmisor.darDireccion()

Direccion direccionReceptor = new Direccion(calle:"Calzada Ermita Iztapalapa", noExterior:"278",noInterior:"501",cPostal:"09470",colonia:"Sinatel", estado:"CDMX",municipio:"Iztapalapa",pais:"México")
Receptor receptor1 = new Receptor(razonSocial:"MAKING DEVS",rfc:"EME910610G1A")
receptor1.direccion = direccionReceptor.darDireccion()

Concepto concepto1 = new Concepto(cantidad:1, descripcion:"Coca-cola 135ml",importe:372.267241)
Concepto concepto2 = new Concepto(cantidad:2, descripcion:"Chetos",importe:249.301724)    
def listaDeConceptos = [concepto1,concepto2]

//Instanciando la factura numero 1 y agregando elementos a sus atributos"
Factura factura1 = new Factura(
							   emisor:emisor1, 
							   nombreDelReceptor:receptor1.razonSocial, 
							   conceptos:listaDeConceptos)
factura1.subtotal = factura1.getSubtotal()
factura1.iva = factura1.getIva()
factura1.total = factura1.getTotal()


//Imprimiendo la factura
println "\n"
println "*"*26 + "FACTURA" + "*"*27
println "\n"
println "Nombre del Emisor: ${factura1.nombreDelEmisor}"
println "Nombre del Receptor: ${factura1.nombreDelReceptor}"
println "Concepto(s)"
println "Cantidad: ${factura1.concepto[0].cantidad}  Descripcion: ${factura1.concepto[0].descripcion} Importe: ${factura1.concepto[0].importe}"
println "Cantidad: ${factura1.concepto[1].cantidad}  Descripcion: ${factura1.concepto[1].descripcion} 	  Importe: ${factura1.concepto[1].importe}"
println "\n"
println "				  Subtotal:${factura1.subtotal}"
println "			                 Iva: ${factura1.iva}"
println "				    Total: ${factura1.total}"
println "\n"
println "*"*60
println "\n"

// Base de datos 
	
println factura1.dump()

String valores = "insert into factura (fecha, nombre_del_emisor, nombre_del_receptor, subtotal, iva, total) values ('${factura1.fecha}', '${factura1.nombreDelEmisor}', '${factura1.nombreDelReceptor}', ${factura1.subtotal.round(2)}, '${factura1.iva.round(2)}', '${factura1.total.round(2)}')"
sql.insertandoIntoTable(valores)
//sql.consultTable()
//sql.execute(comandoInsert)
