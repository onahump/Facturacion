class DireccionReceptor{
  String calle
  String numero
  String cPostal
  String municipio
  String estado
  String pais

  String darDireccion{
    "${calle} ${numero}, ${cPostal},${municipio},${estado},${pais}"
  }

  def direccionEuropea = new DireccionReceptor(calle:"El Carmen",numero:"S/N",cPostal:"04100",municipio:"Coyoacan",estado:"Estado de Mexico",pais:"Mexico"

}

direccionEuropea.darDireccion()


