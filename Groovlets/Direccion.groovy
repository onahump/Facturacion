class Direccion{
  String calle
  String noExterior
  String noInterior
  String cPostal
  String colonia
  String estado
  String municipio
  String pais

  String toString(){
    """\
    ${calle} ,${noExterior}, ${noInterior}, 
    ${colonia}, ${cPostal}, 
    ${municipio}, 
    ${estado},${pais}
    """
  }
}

