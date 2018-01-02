package classes

import java.sql.*
@Grab('mysql:mysql-connector-java:5.1.25')
@GrabConfig(systemClassLoader = true)
import groovy.sql.Sql

@Singleton
class SqlConection {
  def sql =  Sql.newInstance("jdbc:mysql://localhost/facturas","root","makingdevs", "com.mysql.jdbc.Driver")
}