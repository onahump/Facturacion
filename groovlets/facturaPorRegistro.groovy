ContadorPublico yarey = new ContadorPublico()
Factura facturaX = yarey.quieroLaFactura(params.buscar_factura) 

Template index = new Template()

println index.generaUnaVista("facturaPorRegistro",[factura:facturaX])
