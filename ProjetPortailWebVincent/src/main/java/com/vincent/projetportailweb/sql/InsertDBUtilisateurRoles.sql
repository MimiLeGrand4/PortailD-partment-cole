
/*
# To disable foreign key constraints when you want to truncate a table:
SET FOREIGN_KEY_CHECKS=0;
SET FOREIGN_KEY_CHECKS=1;
SET photo = 'Will Smith.png',
nom ='Will',
prenom='Smith',
email='willsMith@gmail.com'
WHERE id=1;
*/
INSERT INTO `mangerbiodb`.`roles` VALUES (1,'Admin','Peut tout faire'),
(2,'Vendeur','Gère les prix des produits, "les clients, expédition, commandes et rapport de ventes'),
(3,'Editeur','Gère les categories, les produits'),
(4,'Expéditeur','Peut voir les products,peut voir les commandes'),
(5,'Assistant',' Gère les questions et Commentaires');

INSERT INTO `mangerbiodb`.`utilisateurs`
(`id`,
`email`,
`active`,
`nom`,
`prenom`,
`password`,
`photo`
)
VALUES
(1,'willsmith@gmail.com',1,'Will','Smith','Smith123','Will Smith.png'),
(2,'kanna.allada@gmail.com',1,'Allada','Pavan','Pavan123','Allada Pavan.png'),
(3,'aecllc.bnk@gmail.com',0,'Bruce','Kitchell','Kitchell123','Bruce Kitchell.png'),
(4,'muhammad.evran13@gmail.com',1,'Muhammad','Evran','Evran123','Muhammad Evran.png'),
(5,'kent.hervey8@gmail.com',1,'Kent','Hervey','Hervey123','KentHervey.png'),
(6,'alfredephraim26@gmail.com',0,'Alfred','Ephraim','Ephraim123','Alfred.png'),
(7,'nathihsa@gmail.com',1,'Nathi','Sangweni','Sangweni123','Nathi_Sangweni.png'),
(8,'ammanollashirisha2020@gmail.com',1,'Ammanolla','Shirisha','Shirisha','Ammanolla.png'),
(9,'bfeeny238@hotmail.com',1,'Bill','Feeny','Feeny123','Bill Feeny.png'),
(10,'redsantosph@gmail.com',1,'Frederick','delos Santos','Santos123','Frederick Santos.png'),
(11,'ro_anamaria@mail.ru',1,'Ana','Maria','Maria123','Anna Maria.jpg'),
(12,'maytassatya@hotmail.com',0,'Satya','Narayana','Narayana123','Satya Narayana.png'),
(13,'matthewefoli@gmail.com',1,'Matthew','Efoli','Matthew123','Matthew.png'),
(14,'davekumara2@gmail.com',1,'Dave','Kumar','Dva123','Dave Kumar.png'),
(15,'jackkbruce@yahoo.com',1,'Jack','Bruce','RoF2da','Jack Bruce.png'),
(16,'zirri.mohamed@gmail.com',1,'Mohamed','Zirri','HQGr78L4kjW','Mohamed Zirri.jpg'),
(17,'mk.majumdar009@hotmail.com',0,'Mithun','Kumar Majumdar','RX8xr2Itui','Mithun Kumar Majumdar.png'),
(18,'aliraza.arain.28@gmail.com',1,'Ali','Raza','JIxcdcPq4G','Ali Raza.png'),
(19,'isaachenry2877@gmail.com',1,'Isaac','Henry','YcHrkRyKpBG8Zca','Isaac Henry.jpg'),
(20,'s.stasovska82@hotmail.com',1,'Svetlana','Stasovska','KFQlR15DwL7QZy','Svetlana Stasovska.png'),
(21,'mikegates2012@gmail.com',1,'Mike','Gates','LLwk8HhK7nVnH.','Mike Gates.png'),
(22,'pedroquintero67@gmail.com',0,'Pedro','Quintero','FYvhu35fMmu','Pedro Quintero.png'),
(23,'amina.elshal2@yahoo.com',1,'Amina','Elshal','NbOZxhXgHu.','Amina Elshal.png');





INSERT INTO `mangerbiodb`. `utilisateurs_roles` VALUES (1,1),(2,1),(3,2),(9,2),(10,2),(11,2),(12,2),(13,2),(19,2),(20,2),(4,3),(5,3),(6,3),(7,3),(8,3),(11,3),(15,3),(18,3),(20,3),(14,4),(15,4),(16,4),(17,4),(18,4),(5,5),(14,5),(19,5),(20,5),(21,5),(22,5),(23,5);




