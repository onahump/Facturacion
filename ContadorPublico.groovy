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

	def quieroLaFactura(def value){
		//String consultaPorId = "select * from factura WHERE id = ${value}"
		def empresas = []
		sql.eachRow('select * from factura'){
		    def emisor = new InvoiceEntity(razonSocial:it.nombre_del_emisor)
		    def receptor = new InvoiceEntity(razonSocial:it.nombre_del_receptor)
		    def ie = new Factura(emisor:emisor,
								 receptor:receptor)

		    empresas << ie
		}
		empresas
		//def objecto = sql.execute(consultaPorId)
		/*sql.eachRow(consultaPorId){
		def ie = new Factura(fecha:fecha,
							 emisor:it.nombre_del_emisor, 
							 receptor:it.nombre_del_emisor,
							 subtotal:it.subtotal,
							 iva:it.iva,
							 total:it.total)
		}
		ie*/
	}
	
}	

/*
String valores = "('2018-01-03', '${factura1.nombreDelEmisor}', '${factura1.nombreDelReceptor}', '${factura1.subtotal}', '${factura1.iva}', '${factura1.total}')"
sql.insertandoIntoTable(valores)
sql.consultTable()
sql.execute(comandoInsert)*/