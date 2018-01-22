import groovy.text.SimpleTemplateEngine

class Templates{

	def engine = new SimpleTemplateEngine()
	def model = [organizacion: "Making Devs"]

	String generaUnTemplateParaRenderear(String nombreDelTemplate){
		def text = new File("html/${nombreDelTemplate}.html").text
		def tmpl = engine.createTemplate(text).make(model)
		
		tmpl.toString()	
	}
}