INSERT INTO `mangerbiodb`.`categories`
(`id`,`nom`)VALUES(1,'FROMAGES'),(2,'PAINS'),(3,'LEGUMES'),(4,'VIANDES');


INSERT INTO `mangerbiodb`.`produit`
(`id`,
`nom`,
`prix`,
`description`,
`url_photo`,
`derniere_maj`,
`categorie_id`)
VALUES
(1,'GRUYERE',2.50,'plaquette','GRUYERE.png','2013-10-18 07:59:14',1),
(2,'PIZZA',2.80,'unité','PIZZA.png','2013-10-18 07:59:14',2),
(3,'RADIS',4.00,'kg','RADIS.png','2013-10-18 07:33:42',3),
(4,'COOKIES',0.50,'pièce','COOKIES.png','2013-10-18 07:23:39',2),
(5,'CAROTTES',3.70,'kg','CAROTTES.png','2013-10-18 07:33:42',3),
(6,'JAMBON',8.50,'kg','JAMBON.png','2013-07-06 22:00:00',4),
(7,'LAIT',1.20,'pack','LAIT.png','2013-07-06 22:00:00',1),
(8,'MAIS',3.00,'kg','MAIS.png','2013-07-06 22:00:00',3),
(9,'CROISSANT',1.76,'unité','CROISSANT.png','2013-10-18 07:59:14',2),
(10,'OEUFS',2.30,'6','OEUFS.png','2013-07-06 22:00:00',1),
(11,'PAIN',1.60,'pièce','PAIN.png','2013-07-06 22:00:00',2),
(12,'TOMATES',1.50,'unité','TOMATES.png','2013-10-18 07:33:42',3),
(13,'PORC',3.20,'kg','PORC.png','2013-10-18 07:59:14',4),
(14,'POULET',12.50,'kg','POULET.png','2013-07-06 22:00:00',4),
(15,'SAUCISSON',1.60,'barquette','SAUCISSON.png','2013-10-18 07:59:14',4),
(16,'TOME',4.50,'kg','TOME.png','2013-07-06 22:00:00',1);