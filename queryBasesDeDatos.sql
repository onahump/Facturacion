CREATE TABLE IF NOT EXISTS factura(                         
cve_factura int(11) NOT NULL AUTO_INCREMENT, 
fecha date NOT NULL,                         
emisor varchar(45) NOT NULL,                 
rfc_emisor varchar(45) NOT NULL,             
receptor varchar(45) NOT NULL,               
rfc_receptor varchar(45) NOT NULL,           
PRIMARY KEY (cve_factura)                    
) 

CREATE TABLE IF NOT EXISTS concepto (                                                                      |
cve_concepto int(5) NOT NULL AUTO_INCREMENT,                                               
cantidad int(5) NOT NULL,                                                                  
descripcion varchar(50) NOT NULL,                                                          
importe decimal(10,2) NOT NULL,                                                               
cve_factura int(11) NOT NULL DEFAULT '0',                                                  
PRIMARY KEY (cve_concepto),                                                                
KEY fk_cve_factura (cve_factura),                                                        
CONSTRAINT fk_cve_factura FOREIGN KEY (cve_factura) REFERENCES factura (cve_factura) 
) 

CREATE TABLE IF NOT EXISTS concepto(
cve_concepto INT(5) NOT NULL auto_increment,
cantidad  int(5) NOT NULL,
descripcion  varchar(50) NOT NULL,
importe float(7,2) NOT null,
cve_factura int NOT NULL,
PRIMARY KEY(cve_concepto)
)

show create table concepto;
-- Eliminando una llave foranea de una tabla donde "concepto_ibfk_1" se obtiene de table concepto
ALTER TABLE concepto DROP FOREIGN KEY concepto_ibfk_1 
-- Cambiando una columna de la tabla 
ALTER TABLE concepto CHANGE COLUMN cve_factura cve_factura integer not null default 0;
-- Agregando llave foranea con restrinccion
alter table concepto add constraint fk_cve_factura foreign key (cve_factura) references factura(cve_factura)


