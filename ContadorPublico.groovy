class ContadorPublico{
	List<Factura> facturas

	def enviarFacturaALaBaseDeDatos(){
		String valores "('${facturas[0].fechaConFormato}', '${facturas[0].emisor}', '${facturas[0].receptor}','${facturas[0].subtotal}', '${facturas[0].iva}', '${facturas[0].total}')"
		//sql.execute(comandoInsert)
		String valores  "('${facturas[1].fechaConFormato}', '${facturas[1].emisor}', '${facturas[1].receptor}','${facturas[1].subtotal}', '${facturas[1].iva}', '${facturas[1].total}')"	
		//sql.execute(comandoInsert)
	}

	def quieroLaFactura(def int){
		
	}
	
}	

/*
String valores = "('2018-01-03', '${factura1.nombreDelEmisor}', '${factura1.nombreDelReceptor}', '${factura1.subtotal}', '${factura1.iva}', '${factura1.total}')"
sql.insertandoIntoTable(valores)
sql.consultTable()
sql.execute(comandoInsert)*/