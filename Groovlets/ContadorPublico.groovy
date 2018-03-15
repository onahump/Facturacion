@GrabConfig(systemClassLoader=true)
@Grab(group='mysql', module='mysql-connector-java', version='5.1.6')
import groovy.sql.Sql


class ContadorPublico{

	def db = [user:"root", pass:'makingdevs',url:'jdbc:mysql://localhost/facturas', driver:'com.mysql.jdbc.Driver']
	def sql = Sql.newInstance(db.url, db.user, db.pass, db.driver)

	void verificaSiLasTablasExisten(){
    	sql.execute """CREATE TABLE IF NOT EXISTS factura(
					cve_factura int(11) NOT NULL AUTO_INCREMENT,
					fecha date NOT NULL,
					emisor varchar(45) NOT NULL,
					rfc_emisor varchar(45) NOT NULL,
					receptor varchar(45) NOT NULL,
					rfc_receptor varchar(45) NOT NULL,
					PRIMARY KEY (cve_factura)
					)"""

		sql.execute """CREATE TABLE IF NOT EXISTS concepto (
					cve_concepto int(5) NOT NULL AUTO_INCREMENT,
					cantidad int(5) NOT NULL,
					descripcion varchar(50) NOT NULL,
					importe decimal(10,2) NOT NULL,
					cve_factura int(11) NOT NULL DEFAULT '0',
					PRIMARY KEY (cve_concepto),
					KEY fk_cve_factura (cve_factura),
					CONSTRAINT fk_cve_factura FOREIGN KEY (cve_factura) REFERENCES factura (cve_factura)
					)"""
	}



	String registraLaFactura(Factura factura){
		String insertandoFactura = "insert into factura (fecha, emisor, rfc_emisor, receptor, rfc_receptor) values ('${factura.fecha.format('yyyy-MM-dd')}', '${factura.emisor.razonSocial}', '${factura.emisor.rfc}', '${factura.receptor.razonSocial}', '${factura.receptor.rfc}')"
  		sql.execute(insertandoFactura)

  		def ultimoIdRegistrado = sql.rows("SELECT LAST_INSERT_ID()")
        String parseoDelUltimoIdRegistrado = ultimoIdRegistrado
       	String id = parseoDelUltimoIdRegistrado.findAll(/\d+/).first()

  		factura.conceptos.each{
            sql.execute("insert into concepto (cantidad, descripcion, importe,cve_factura) values ('${it.cantidad}','${it.descripcion}', '${it.importe}', '${id}')")
        }
  	}

	def quieroLaFactura(def value){
		def cantidadDeFacturasEnLaBaseDeDatos = sql.rows("select count(*) from factura")
		String parseaCantidadDeFacturas = cantidadDeFacturasEnLaBaseDeDatos
       	Integer cantidad = parseaCantidadDeFacturas.findAll(/\d+/).first().toInteger()

		if(value > cantidad){
			"Esta factura no se encuentra debido a que solo existen ${cantidad} registros, ingresa un numero válido"
		}else{
			String consultaFacturaPorClave = "select * from factura WHERE cve_factura = ${value}"
			def parseo = sql.rows(consultaFacturaPorClave)

			InvoiceEntity emisor =  new InvoiceEntity(razonSocial:parseo.emisor.first(), rfc:parseo.rfc_emisor.first() )
			InvoiceEntity receptor =  new InvoiceEntity(razonSocial:parseo.receptor.first(),rfc:parseo.rfc_receptor.first() )

			def listaDeConceptos = []

			sql.eachRow("select cantidad,descripcion,importe from concepto where cve_factura = ${value}"){
		    	def concepto = new Concepto(cantidad:it.cantidad, descripcion:it.descripcion, importe:it.importe)
		    	listaDeConceptos << concepto
	    	}

			Factura factura = new Factura(fecha:parseo.fecha.first(),
									  emisor:emisor,
									  receptor:receptor,
									  conceptos:listaDeConceptos)
			factura
		}
	}

	def quieroTodasLasFacturas(){
		List listaDeCveDeFactura = []
		def listaDeEmisores = []
		def listaRfcEmisores = []
		def listaDeReceptores = []
		def listaRfcReceptores = []

		sql.eachRow("select * from factura"){ row ->
     		listaDeCveDeFactura << row.cve_factura
     		listaDeEmisores << row.emisor
     		listaRfcEmisores << row.rfc_emisor
     		listaDeReceptores << row.receptor
     		listaRfcReceptores << row.rfc_receptor
		}
		Map superMapa = [claves:listaDeCveDeFactura, emisores:listaDeEmisores, rfcEmisores:listaRfcEmisores, receptores:listaDeReceptores, rfcReceptores:listaRfcReceptores]
  }

   def quieroLaFacturaPorFecha(String fecha){
		String consultaFacturaPorFecha = "select * from factura where fecha like '%${fecha}%'"
		
		def listaDeFacturas = []
		sql.eachRow(consultaFacturaPorFecha){ parseo ->	
			InvoiceEntity emisor =  new InvoiceEntity(razonSocial:parseo.emisor, rfc:parseo.rfc_emisor )
			InvoiceEntity receptor =  new InvoiceEntity(razonSocial:parseo.receptor,rfc:parseo.rfc_receptor )

			def listaDeConceptos = []
			sql.eachRow("select cantidad,descripcion,importe from concepto where cve_factura = ${parseo.cve_factura}"){
		    	def concepto = new Concepto(cantidad:it.cantidad, descripcion:it.descripcion, importe:it.importe)
		    	listaDeConceptos << concepto
	    	}

			Factura factura = new Factura(fecha:parseo.fecha,
									  emisor:emisor,
									  receptor:receptor,
									  conceptos:listaDeConceptos)

			listaDeFacturas << factura
		}
		listaDeFacturas
	}

	   def quieroLaFacturaPorNombreDelEmisorReceptor(String nombreDelEmisor){
		String consultaFacturaPorFecha = "SELECT * FROM factura WHERE emisor LIKE '%${nombreDelEmisor}%' OR receptor LIKE '%${nombreDelEmisor}%'"

		
		def listaDeFacturas = []
		sql.eachRow(consultaFacturaPorFecha){ parseo ->	
			InvoiceEntity emisor =  new InvoiceEntity(razonSocial:parseo.emisor, rfc:parseo.rfc_emisor )
			InvoiceEntity receptor =  new InvoiceEntity(razonSocial:parseo.receptor,rfc:parseo.rfc_receptor )

			def listaDeConceptos = []
			sql.eachRow("select cantidad,descripcion,importe from concepto where cve_factura = ${parseo.cve_factura}"){
		    	def concepto = new Concepto(cantidad:it.cantidad, descripcion:it.descripcion, importe:it.importe)
		    	listaDeConceptos << concepto
	    	}

			Factura factura = new Factura(fecha:parseo.fecha,
									  emisor:emisor,
									  receptor:receptor,
									  conceptos:listaDeConceptos)

			listaDeFacturas << factura
		}
		listaDeFacturas
	}
}
