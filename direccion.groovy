package clasess

class Direccion{
  Boolean tipo
  String calle
  String noExterior
  String noInterior
  String cPostal
  String colonia
  String estado
  String localidad
  String pais

  void darDireccion(){
    "${tipo}, ${calle} ,${noExterior}, ${noInterior}, ${cPostal},${colonia}, ${localidad}, ${estado},${pais}"
  }
}


