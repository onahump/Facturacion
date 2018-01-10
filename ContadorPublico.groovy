@GrabConfig(systemClassLoader=true)
@Grab(group='mysql', module='mysql-connector-java', version='5.1.6')
import groovy.sql.Sql


class ContadorPublico{

	def db = [user:"root", pass:'makingdevs',url:'jdbc:mysql://localhost/facturas', driver:'com.mysql.jdbc.Driver']
	def sql = Sql.newInstance(db.url, db.user, db.pass, db.driver)	

	String registraLaFactura(def factura){
		def comandoInsert = "insert into factura (fecha,nombre_del_emisor, nombre_del_receptor, subtotal, iva, total) values ('${factura.fecha.format('yyyy-dd-MM')}', '${factura.emisor}', '${factura.receptor}', '${factura.subtotal.round(2)}', '${factura.iva.round(2)}', '${factura.total.round(2)}')"
  		sql.execute(comandoInsert)
	}

	Factura quieroLaFactura(def value){
		String consultaPorId = "select * from factura WHERE id = ${value}"
		def parseo = sql.rows(consultaPorId)

		def emisor =  new InvoiceEntity(razonSocial:parseo.nombre_del_emisor.first())
		def receptor =  new InvoiceEntity(razonSocial:parseo.nombre_del_receptor.first())
		
		def fecha = new Date()
		Concepto concepto2 = new Concepto(cantidad:1, 
								  descripcion:"Chetos",
								  importe:12.13)  
		def listaDeConceptos = [concepto2]

		def factura = new Factura(fecha:fecha,
								  emisor:emisor,
								  receptor:receptor,
								  conceptos:listaDeConceptos)
		factura
	}
	
}	