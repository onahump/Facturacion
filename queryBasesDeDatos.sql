CREATE TABLE IF NOT EXISTS factura(
cve_factura INT NOT NULL auto_increment,
fecha date NOT NULL,
emisor  varchar(45) NOT NULL,
rfc_emisor  varchar(45) NOT NULL,
receptor  varchar(45) NOT NULL,
rfc_receptor  varchar(45) NOT NULL,
subtotal float(7,2) NOT null,
iva float(7,2) NOT null,
total float(7,2) NOT null,
PRIMARY KEY(cve_factura)
)

CREATE TABLE IF NOT EXISTS concepto(
cve_concepto INT(5) NOT NULL auto_increment,
cantidad  int(5) NOT NULL,
descripcion  varchar(50) NOT NULL,
importe float(7,2) NOT null,
cve_factura int NOT NULL,
PRIMARY KEY(cve_concepto),
FOREIGN KEY(cve_factura) REFERENCES factura(cve_factura)
		ON DELETE CASCADE
		ON UPDATE CASCADE
)

CREATE TRIGGER trigger1
AFTER INSERT
ON factura
FOR EACH ROW
BEGIN
  INSERT INTO concepto VALUES (NULL, 'coca', 15.92 , NEW.id);
END