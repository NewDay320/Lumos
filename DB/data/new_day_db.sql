CREATE TABLE  IF NOT EXISTS `rx` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
  `comercial_name` VARCHAR(45) NOT NULL,
  `generic_name` VARCHAR(45) NULL,
  `description` TEXT NULL );


CREATE TABLE  IF NOT EXISTS [rx_dose] (
  [Rx_id] INT NOT NULL CONSTRAINT [fk_rx_dose_Rx] REFERENCES [rx]([id]), 
  [dose_seq] INTEGER NOT NULL, 
  [dose] VARCHAR(100) NOT NULL, 
  [form] VARCHAR(100) NOT NULL, 
  [img_path] VARCHAR(255), 
  CONSTRAINT [sqlite_autoindex_rx_dose_1] PRIMARY KEY ([dose_seq], [Rx_id]));
 
CREATE TABLE  IF NOT EXISTS  patient  (
   `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `dob` DATE NOT NULL );
  
  
CREATE TABLE IF NOT EXISTS  `relationship_type` (
  `type` VARCHAR(50) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`type`))  
;
 
 
CREATE TABLE IF NOT EXISTS `patient_contact` (
  `patient_id` INT NOT NULL,
  `contact_id` INT NOT NULL,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `relationship_type` VARCHAR(5) NOT NULL,
  `other_relation_info` VARCHAR(100) NULL ,
  PRIMARY KEY (`patient_id`, `contact_id`),
   CONSTRAINT `fk_patient_contact_patient1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `patient` (`id`),
  CONSTRAINT `fk_patient_contact_relationship_type1`
    FOREIGN KEY (`relationship_type`)
    REFERENCES `relationship_type` (`type`))
 ;

 
CREATE TABLE  `contact_info` (
  `patient_id` INT NOT NULL,
  `contact_id` INT NOT NULL,
  `contact_seq` INT NOT NULL,
  `phone_num` VARCHAR(45) NOT NULL,
  `notes` VARCHAR(500) NULL,
  PRIMARY KEY (`patient_id`, `contact_id`, `contact_seq`) )
  ;
  
 -- ??? TODO - had to disable FK constraint to get data in
 --  CONSTRAINT `fk_contact_info_patient_contact1`
 --   FOREIGN KEY (`patient_id`)
 --   REFERENCES `patient_contact` (`patient_id`)

 -- -----------------------------------------------------
-- Table `event_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `event_type` (
  `id` VARCHAR(20) NOT NULL  ,
  `description` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
;

 