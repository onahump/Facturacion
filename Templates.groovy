import groovy.text.SimpleTemplateEngine

class Templates{

	def engine = new SimpleTemplateEngine()

	String generaUnTemplateParaRenderear(String nombreDelTemplate, Map model = [:]){
		def text = new File("html/${nombreDelTemplate}.html").text
		def tmpl = engine.createTemplate(text).make(model)
		
		tmpl.toString()	
	}
}