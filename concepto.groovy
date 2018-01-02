package classes

class Concepto{
	Integer cantidad
	String descripcion 
	Float importe

	def getSubtotal(Float subtotal){
		subtotal += importe
	}
}
