ContadorPublico yarey = new ContadorPublico()
def facturaX = yarey.quieroLaFacturaPorFecha(params.buscar_factura.toInteger()) 

Template index = new Template()

println index.generaUnaVista("facturaPorRegistro",[factura:facturaX])
