@GrabConfig(systemClassLoader=true)
@Grab(group='mysql', module='mysql-connector-java', version='5.1.6')
import groovy.sql.Sql


class ContadorPublico{

	def db = [user:"root", pass:'makingdevs',url:'jdbc:mysql://localhost/facturas', driver:'com.mysql.jdbc.Driver']
	def sql = Sql.newInstance(db.url, db.user, db.pass, db.driver)	

	String registraLaFactura(def factura){
		String comandoInsert = "insert into factura (fecha, nombre_del_emisor, emisor_rfc, nombre_del_receptor, receptor_rfc, subtotal, iva, total) values ('${factura.fecha.format('yyyy-dd-MM')}', '${factura.emisor.razonSocial}', '${factura.emisor.rfc}', '${factura.receptor.razonSocial}', '${factura.receptor.rfc}', '${factura.subtotal}', '${factura.iva}', '${factura.total}')"
  		sql.execute(comandoInsert)
	}

	Factura quieroLaFactura(def value){
		String consultaPorId = "select * from factura WHERE id = ${value}"
		def parseo = sql.rows(consultaPorId)

		InvoiceEntity emisor =  new InvoiceEntity(razonSocial:parseo.nombre_del_emisor.first(), rfc:parseo.emisor_rfc.first() )
		InvoiceEntity receptor =  new InvoiceEntity(razonSocial:parseo.nombre_del_receptor.first(),rfc:parseo.receptor_rfc.first() )
		
		Concepto concepto2 = new Concepto(cantidad:1, 
								  		  descripcion:"Chetos",
								  		  importe:12.13)  
		def listaDeConceptos = [concepto2]

		Factura factura = new Factura(fecha:parseo.fecha.first(),
								  emisor:emisor,
								  receptor:receptor,
								  conceptos:listaDeConceptos)
		factura
	}
	
}	