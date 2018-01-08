class ContadorPublico{
	List<Factura> facturas

	//SqlConection sql = SqlConection.getInstance() //Estableciendo conecion con la base de datos

	String enviarFacturasALaBaseDeDatos(){
		facturas.eachWithIndex{i,index ->
			println "('${facturas[index].fechaConFormato}', '${facturas[index].emisor}', '${facturas[index].receptor}','${facturas[index].subtotal}', '${facturas[index].iva}', '${facturas[index].total}')"	
			//sql.execute(comandoInsert)
		}
	}

	def quieroLaFactura(){

	}
	
}	

/*
String valores = "('2018-01-03', '${factura1.nombreDelEmisor}', '${factura1.nombreDelReceptor}', '${factura1.subtotal}', '${factura1.iva}', '${factura1.total}')"
sql.insertandoIntoTable(valores)
sql.consultTable()
sql.execute(comandoInsert)*/