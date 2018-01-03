class Direccion{
  String calle
  String noExterior
  String noInterior
  String cPostal
  String colonia
  String estado
  String municipio
  String pais

  String darDireccion(){
    "${calle} ,${noExterior}, ${noInterior}, ${cPostal},${colonia}, ${municipio}, ${estado},${pais}"
  }
}

