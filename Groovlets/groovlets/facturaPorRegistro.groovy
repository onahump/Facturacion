ContadorPublico yarey = new ContadorPublico()
def facturaX = yarey.quieroLaFactura(params.buscar_factura.toInteger()) 

Template index = new Template()

println index.generaUnaVista("facturaPorRegistro",[factura:facturaX])
