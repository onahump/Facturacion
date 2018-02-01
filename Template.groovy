import groovy.text.SimpleTemplateEngine

class Template{
		
	def engine = new SimpleTemplateEngine()

	String generaUnaVista(String nombreDelTemplate, Map model = [:]){
	def text = new File("html/${nombreDelTemplate}.html").text
	def tmpl = engine.createTemplate(text).make(model)
		
	tmpl.toString()	
	}

}