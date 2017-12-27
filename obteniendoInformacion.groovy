def leyendoFactura = new XmlParser().parse("archivo.xml")
leyendoFactura.declareNamespace(cfdi:'http://www.sat.gob.mx/cfd/3')

println leyendoFactura.Conceptos.'cfdi:Concepto'.each { println it.'@descripcion' }

