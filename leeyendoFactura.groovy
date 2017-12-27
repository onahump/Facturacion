class leeyendoFactura{	
	def factura = new XmlSlurper().parse("archivo.xml")
	factura.declareNamespace(cfdi:'http://www.sat.gob.mx/cfd/3')

	def conceptos = [:]
	factura.Conceptos.'cfdi:Concepto'.each{ 
		conceptos.put(it.'@descripcion',it.'@importe')
	}

	def receptor = [:]
	factura.Receptor.each{ 
		receptor << [nombre:it.'@nombre',
				   rfc:it.'@rfc']
	}

	def direccionEmisor = [:]
	factura.Receptor.'cfdi:Domicilio'.each{ 
		direccionEmisor << [calle:it.'@calle',
							noExterior:it.'@noExterior',
							noInterior:it.'@noInterior',
							codigoPostal:it.'@codigoPostal',
							colonia:it.'@colonia',
							estado:it.'@estado',
							localidad:it.'@localidad',
							pais:it.'@pais']
	}


	def emisor = [:]
	factura.Emisor.each{ 
		emisor << [nombre:it.'@nombre',
				   rfc:it.'@rfc']
	}

	def direccionFiscalEmisor = [:]
	factura.Emisor.'cfdi:DomicilioFiscal'.each{ 
		direccionFiscalEmisor << [calle:it.'@calle',
							noExterior:it.'@noExterior',
							noInterior:it.'@noInterior',
							codigoPostal:it.'@codigoPostal',
							colonia:it.'@colonia',
							estado:it.'@estado',
							localidad:it.'@localidad',
							pais:it.'@pais']
	}

	def direccionEmisorExpedida = [:]
	factura.Emisor.'cfdi:ExpedidoEn'.each{ 
		direccionEmisorExpedida << [calle:it.'@calle',
							noExterior:it.'@noExterior',
							noInterior:it.'@noInterior',
							codigoPostal:it.'@codigoPostal',
							colonia:it.'@colonia',
							estado:it.'@estado',
							localidad:it.'@localidad',
							pais:it.'@pais']
	}

	def iva = [:]
	factura.Impuestos.Traslados.'cfdi:Traslado'.each{ 
		iva << [iva:it.'@importe',
				tasa:it.'@tasa']
	}
}



