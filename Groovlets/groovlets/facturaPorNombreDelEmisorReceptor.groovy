ContadorPublico yarey = new ContadorPublico()

def listaDeFacturas = yarey.quieroLaFacturaPorNombreDelEmisorReceptor(params.buscar_factura)
Template index = new Template()

println index.generaUnaVista("facturaPorNombreDelEmisorReceptor",[facturas:listaDeFacturas])

