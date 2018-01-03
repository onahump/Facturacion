package classes

import java.sql.*
@Grab('mysql:mysql-connector-java:5.1.25')
@GrabConfig(systemClassLoader = true)
import groovy.sql.Sql



@Singleton
class SqlConection {
  def sql =  Sql.newInstance("jdbc:mysql://localhost:3306/facturas","root","makingdevs", "com.mysql.jdbc.Driver")
  
  void consultTable(){""
  	sql.eachRow('select * from factura') {
    tp ->
      println(tp.iva	)
  	}
  }

  void insertandoIntoTable(String valores){
  	//String comandoInsert = " insert into factura (fecha,nombre_del_emisor, nombre_del_receptor, subtotal, iva, total) values ${valores}"
  	sql.execute(valores)
  }


}
