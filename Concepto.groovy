class Concepto{
	Integer cantidad
	String descripcion 
	BigDecimal importe

	BigDecimal getImporteTotal(){
		cantidad * importe
	}

	String toString(){
	  "Cantidad: ${cantidad}  Descripcion: ${descripcion} Importe: ${importeTotal}"
	}
}
