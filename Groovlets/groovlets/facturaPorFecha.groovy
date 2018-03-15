ContadorPublico yarey = new ContadorPublico()

def listaDeFacturas = yarey.quieroLaFacturaPorFecha(params.buscar_factura)
Template index = new Template()

println index.generaUnaVista("facturaPorFecha",[facturas:listaDeFacturas])

