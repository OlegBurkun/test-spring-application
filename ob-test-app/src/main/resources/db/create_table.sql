CREATE TABLE table_of_content (
	id int NOT NULL AUTO_INCREMENT,
	text_field varchar(255),
	numeric_field BIGINT(20),
	boolean_field TINYINT(1) NOT NULL DEFAULT '0',
	date_field DATETIME NOT NULL DEFAULT NOW()
);