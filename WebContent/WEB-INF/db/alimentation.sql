/* table Preference */

INSERT INTO "Preference" VALUES(1,0,0,0,0);
INSERT INTO "Preference" VALUES(2,0,0,0,1);
INSERT INTO "Preference" VALUES(3,0,0,1,0);
INSERT INTO "Preference" VALUES(4,0,0,1,1);
INSERT INTO "Preference" VALUES(5,0,1,0,0);
INSERT INTO "Preference" VALUES(6,0,1,0,1);
INSERT INTO "Preference" VALUES(7,0,1,1,0);
INSERT INTO "Preference" VALUES(8,0,1,1,1);
INSERT INTO "Preference" VALUES(9,1,0,0,0);
INSERT INTO "Preference" VALUES(10,1,0,0,1);
INSERT INTO "Preference" VALUES(11,1,0,1,0);
INSERT INTO "Preference" VALUES(12,1,0,1,1);
INSERT INTO "Preference" VALUES(13,1,1,0,0);
INSERT INTO "Preference" VALUES(14,1,1,0,1);
INSERT INTO "Preference" VALUES(15,1,1,1,0);
INSERT INTO "Preference" VALUES(16,1,1,1,1);


/* table Ville */

INSERT INTO "Ville" VALUES(1,'Lomme',59160);
INSERT INTO "Ville" VALUES(2,'Lille',59000);
INSERT INTO "Ville" VALUES(3,'Paris',75056);
INSERT INTO "Ville" VALUES(4,'Marseille',13000);
INSERT INTO "Ville" VALUES(5,'Lyon',69001);
INSERT INTO "Ville" VALUES(6,'Toulouse',31000);
INSERT INTO "Ville" VALUES(7,'Nice',6000);
INSERT INTO "Ville" VALUES(8,'Nantes',44000);
INSERT INTO "Ville" VALUES(9,'Strasbourg',67000);
INSERT INTO "Ville" VALUES(10,'Montpellier',34000);

/* table Profil */

INSERT INTO "Profil" VALUES(1,'claude27','pass','claude27@kol.uk','2015-11-12','1957-10-10','DUPOND','Claude',1,3);
INSERT INTO "Profil" VALUES(2,'sandrinette','pass','sandrinette@yop.ph','2013-02-26','1990-07-21','Paige','Sandrine',2,14);
INSERT INTO "Profil" VALUES(3,'tony','pass','tony@er.gj','2015-11-23','1986-07-18','AARON','anthony',3,4);
INSERT INTO "Profil" VALUES(4,'mel','pass','melimelo@jk.sd','2013-12-02','1976-05-22','MOREL','melanie',4,11);

/* table Trajet */

INSERT INTO "Trajet" VALUES(1,2,3,'2015-12-22','10:20',4,7.5,1);
INSERT INTO "Trajet" VALUES(2,3,4,'2015-12-28','7:30',3,15.5,3);
INSERT INTO "Trajet" VALUES(3,6,10,'2015-12-19','14:00',1,10,1);

/* table Message */

INSERT INTO "Message" VALUES(1,'Valise','Il y a de la place pour une valise moyenne ?',1,2,3);


/* table Voyageurs */

INSERT INTO "Voyageurs" VALUES(2,1);
INSERT INTO "Voyageurs" VALUES(2,3);
INSERT INTO "Voyageurs" VALUES(3,1);

/* table Paiement */

INSERT INTO "Paiement" VALUES(2,1,1);
INSERT INTO "Paiement" VALUES(2,3,1);
INSERT INTO "Paiement" VALUES(3,1,1);
INSERT INTO "Paiement" VALUES(4,2,0);
