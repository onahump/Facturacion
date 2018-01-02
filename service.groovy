package clasess

class Service{	

	def readFacturaXML(){
		def factura = new XmlSlurper().parse(new File('source/archivo.xml'))
		factura.declareNamespace(cfdi:'http://www.sat.gob.mx/cfd/3')
	}	

	def getConceptos(def readConcepto){
		def conceptos_Mapa = [:]
		readConcepto.Conceptos.'cfdi:Concepto'.each{ 
		conceptos_Mapa.put(it.'@descripcion',it.'@importe')
		}
		return conceptos_Mapa
	}

	def getReceptor(def readReceptor){
		def receptor_Mapa = [:]
		readReceptor.Receptor.each{ 
		receptor_Mapa << [nombre:it.'@nombre',
					 rfc:it.'@rfc']
		}
		return receptor_Mapa
	}
		
	def getEmisor(def readEmisor){
		def emisor_Mapa = [:]
		readEmisor.Emisor.each{ 
			emisor_Mapa << [nombre:it.'@nombre',
					   rfc:it.'@rfc']
		}
		return emisor_Mapa
	}

	def getIva(def readIva){
		def iva_Mapa = [:]
		readIva.Impuestos.Traslados.'cfdi:Traslado'.each{ 
			iva_Mapa << [iva:it.'@importe',
					tasa:it.'@tasa']
		}
		return iva_Mapa
	}

	def getDireccionEmisor(def readAddresEmisor){
		def direccionEmisor = [:]
		readAddres.Emisor.'cfdi:Domicilio'.each{ 
			direccionEmisor << [calle:it.'@calle',
								noExterior:it.'@noExterior',
								noInterior:it.'@noInterior',
								codigoPostal:it.'@codigoPostal',
								colonia:it.'@colonia',
								estado:it.'@estado',
								localidad:it.'@localidad',
								pais:it.'@pais']
		}
		return direccionEmisor
	}
	
	def getDireccionReceptor(def readAddresReceptor){
		def direccionReceptor = [:]
		readAddresReceptor.Receptor.'cfdi:Domicilio'.each{ 
			direccionReceptor << [calle:it.'@calle',
								noExterior:it.'@noExterior',
								noInterior:it.'@noInterior',
								codigoPostal:it.'@codigoPostal',
								colonia:it.'@colonia',
								estado:it.'@estado',
								localidad:it.'@localidad',
								pais:it.'@pais']
		}
		return direccionReceptor
	}

	def conceptosDeFactura = getConceptos(newFactura)
	def recepor = getReceptor(newFactura)
	def emisor = getEmisor(newFactura)
	def iva = getIva(newFactura)
	def direccionEmisor = getDireccionEmisor(newFactura)
	def direccionReceptor = getDireccionReceptor(newFactura)
}



