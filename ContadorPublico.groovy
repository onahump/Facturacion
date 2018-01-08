@GrabConfig(systemClassLoader=true)
@Grab(group='mysql', module='mysql-connector-java', version='5.1.6')
import groovy.sql.Sql


class ContadorPublico{

	def db = [user:"root", pass:'makingdevs',url:'jdbc:mysql://localhost/facturas', driver:'com.mysql.jdbc.Driver']
	def sql = Sql.newInstance(db.url, db.user, db.pass, db.driver)	

	String enviarFacturasALaBaseDeDatos(){
		
	}

	def quieroLaFactura(){
	}

	def dimeTodasLasRazonesSociales(){
		def empresas = []
		sql.eachRow('select * from invoice_entity'){
		    def ie = new InvoiceEntity(razonSocial:it.razon_social, rfc:it.rfc)
		    empresas << ie
		}
		empresas
	}
	
}	

/*
String valores = "('2018-01-03', '${factura1.nombreDelEmisor}', '${factura1.nombreDelReceptor}', '${factura1.subtotal}', '${factura1.iva}', '${factura1.total}')"
sql.insertandoIntoTable(valores)
sql.consultTable()
sql.execute(comandoInsert)*/