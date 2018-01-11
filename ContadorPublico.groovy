@GrabConfig(systemClassLoader=true)
@Grab(group='mysql', module='mysql-connector-java', version='5.1.6')
import groovy.sql.Sql


class ContadorPublico{

	def db = [user:"root", pass:'makingdevs',url:'jdbc:mysql://localhost/facturas', driver:'com.mysql.jdbc.Driver']
	def sql = Sql.newInstance(db.url, db.user, db.pass, db.driver)	

	String registraLaFactura(Factura factura){
		String insertandoFactura = "insert into factura (fecha, emisor, rfc_emisor, receptor, rfc_receptor, subtotal, iva, total) values ('${factura.fecha.format('yyyy-dd-MM')}', '${factura.emisor.razonSocial}', '${factura.emisor.rfc}', '${factura.receptor.razonSocial}', '${factura.receptor.rfc}', '${factura.subtotal}', '${factura.iva}', '${factura.total}')"
  		sql.execute(insertandoFactura)
  		/*factura.conceptos.each{ 
            sql.execute("insert into concepto (cantidad, descripcion, importe) values ('${it.cantidad}','${it.descripcion}', '${it.importe}')");
   	  		
        }*/
  	}

	Factura quieroLaFactura(def value){
		String consultaPorId = "select * from factura WHERE cve_factura = ${value}"
		def parseo = sql.rows(consultaPorId)

		InvoiceEntity emisor =  new InvoiceEntity(razonSocial:parseo.emisor.first(), rfc:parseo.rfc_emisor.first() )
		InvoiceEntity receptor =  new InvoiceEntity(razonSocial:parseo.receptor.first(),rfc:parseo.rfc_receptor.first() )
		
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