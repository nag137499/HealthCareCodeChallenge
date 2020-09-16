DROP TABLE IF EXISTS enrollees;
DROP TABLE IF EXISTS dependents;

CREATE TABLE enrollees ( 
   id INT NOT NULL AUTO_INCREMENT, 
   name VARCHAR(50) NOT NULL, 
   activation_status VARCHAR(20) NOT NULL, 
   dob DATE NOT NULL,
   phone_number VARCHAR(15),
   PRIMARY KEY(id)
);

CREATE TABLE dependents
   ( id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,    
	dob DATE NOT NULL
	PRIMARY KEY(id),
  CONSTRAINT fk_con_userId FOREIGN KEY (enrollee_id)
    REFERENCES enrollees (id)
  ON DELETE CASCADE ON UPDATE NO ACTION
);