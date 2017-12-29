class DireccionEmisor{
  Boolean tipo
  String calle
  String noExterior
  String noInterior
  String cPostal
  String colonia
  String estado
  String localidad
  String pais

  String darDireccion{
    "${calle} ${numero}, ${cPostal},${municipio},${estado},${pais}"
  }
}


