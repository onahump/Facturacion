yarey = new ContadorPublico()
Map superMapa = yarey.quieroTodasLasFacturas()

List claves = superMapa.claves
List emisores = superMapa.emisores
List rfcEmisores = superMapa.rfcEmisores
List receptores = superMapa.receptores
List rfcReceptores = superMapa.rfcReceptores

Template index = new Template()

println index.generaUnaVista("todasLasFacturas",[claves:claves, emisores:emisores, rfcEmisores:rfcEmisores, receptores: receptores, rfcReceptores:rfcReceptores])

