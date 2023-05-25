CREATE DATABASE projetSession;
USE projetSession;

CREATE TABLE tbl_accountType (
                                 id int,
                                 nom varchar(30),

                                 PRIMARY KEY (id)
);

CREATE TABLE tbl_user (
                          id int AUTO_INCREMENT,
                          nom varchar(35),
                          prenom varchar(35),
                          accounttype_id int,
                          passwd varchar(99),
                          tuteur Boolean,
                          email varchar(255),

                          PRIMARY KEY (id),
                          FOREIGN KEY (accounttype_id) REFERENCES tbl_accountType(id)
);

CREATE TABLE tbl_session (
                             id int AUTO_INCREMENT,
                             nom varchar(50),

                             PRIMARY KEY (id)
);

CREATE TABLE tbl_profil (
                            id int AUTO_INCREMENT,
                            nom varchar(50),

                            PRIMARY KEY (id)
);

CREATE TABLE tbl_projet (
                            id int AUTO_INCREMENT,
                            nom varchar(50),
                            `description` text,
                            session_id int,
                            profil_id int,
                            user_id int,
                            statut Boolean,
                            url_video_presentation varchar(100),
                            url_projet_git varchar(255),

                            PRIMARY KEY (id),
                            FOREIGN KEY (user_id) REFERENCES tbl_user(id),
                            FOREIGN KEY (session_id) REFERENCES tbl_session(id),
                            FOREIGN KEY (profil_id) REFERENCES tbl_profil(id)
);

CREATE TABLE tbl_evaluation(
                               id int AUTO_INCREMENT,
                               user_id int ,
                               projet_id int ,
                               note int(3),
                               commentaire text,


                               PRIMARY KEY (id),
                               FOREIGN KEY (projet_id) REFERENCES tbl_projet(id),
                               FOREIGN KEY (user_id) REFERENCES tbl_user(id)
);

CREATE TABLE tbl_fichier(
                            id int AUTO_INCREMENT,
                            nom varchar(30),
                            contenu varchar(100),
                            user_id int ,

                            PRIMARY KEY (id),
                            FOREIGN KEY (user_id) REFERENCES tbl_user(id)
);

INSERT INTO tbl_accountType VALUES (
                                       0,
                                       'administrator'
                                   );
INSERT INTO tbl_accountType VALUES (
                                       1,
                                       'invite'
                                   );
INSERT INTO tbl_accountType VALUES (
                                       2,
                                       'etudiant'
                                   );
INSERT INTO tbl_accountType VALUES (
                                       3,
                                       'professeur'
                                   );
INSERT INTO tbl_accountType VALUES (
                                       4,
                                       'ancienEtudiant'
                                   );


INSERT INTO tbl_session VALUES (
                                   1,
                                   'Automne2010'
                               );
INSERT INTO tbl_session VALUES (
                                   2,
                                   'Hiver2011'
                               );
INSERT INTO tbl_session VALUES (
                                   3,
                                   'Automne2011'
                               );
INSERT INTO tbl_session VALUES (
                                   4,
                                   'Hiver2012'
                               );
INSERT INTO tbl_session VALUES (
                                   5,
                                   'Automne2012'
                               );
INSERT INTO tbl_session VALUES (
                                   6,
                                   'Hiver2013'
                               );
INSERT INTO tbl_session VALUES (
                                   7,
                                   'Automne2013'
                               );
INSERT INTO tbl_session VALUES (
                                   8,
                                   'Hiver2014'
                               );
INSERT INTO tbl_session VALUES (
                                   9,
                                   'Automne2014'
                               );
INSERT INTO tbl_session VALUES (
                                   10,
                                   'Hiver2015'
                               );
INSERT INTO tbl_session VALUES (
                                   11,
                                   'Automne2015'
                               );
INSERT INTO tbl_session VALUES (
                                   12,
                                   'Hiver2016'
                               );
INSERT INTO tbl_session VALUES (
                                   13,
                                   'Automne2016'
                               );
INSERT INTO tbl_session VALUES (
                                   14,
                                   'Hiver2017'
                               );
INSERT INTO tbl_session VALUES (
                                   15,
                                   'Automne2017'
                               );
INSERT INTO tbl_session VALUES (
                                   16,
                                   'Hiver2018'
                               );
INSERT INTO tbl_session VALUES (
                                   17,
                                   'Automne2018'
                               );
INSERT INTO tbl_session VALUES (
                                   18,
                                   'Hiver2019'
                               );
INSERT INTO tbl_session VALUES (
                                   19,
                                   'Automne2019'
                               );
INSERT INTO tbl_session VALUES (
                                   20,
                                   'Hiver2020'
                               );
INSERT INTO tbl_session VALUES (
                                   21,
                                   'Automne2020'
                               );
INSERT INTO tbl_session VALUES (
                                   22,
                                   'Hiver2021'
                               );
INSERT INTO tbl_session VALUES (
                                   23,
                                   'Automne2021'
                               );
INSERT INTO tbl_session VALUES (
                                   24,
                                   'Hiver2022'
                               );
INSERT INTO tbl_session VALUES (
                                   25,
                                   'Automne2022'
                               );
INSERT INTO tbl_session VALUES (
                                   26,
                                   'Hiver2023'
                               );


INSERT INTO tbl_profil VALUES (
                                  1,
                                  'Réseautique'
                              );
INSERT INTO tbl_profil VALUES (
                                  2,
                                  'Programmation'
                              );

INSERT INTO tbl_user VALUES (
                                1,
                                "Admin",
                                "Admin",
                                0,
                                "root",
                                FALSE,
                                "root"
                            );
INSERT INTO tbl_user VALUES (
                                2,
                                "Invité",
                                "Invité",
                                1,
                                "",
                                FALSE,
                                ""
                            );
INSERT INTO tbl_user VALUES (
                                3,
                                "Cormier",
                                "Jérémy",
                                2,
                                "RalphBisou",
                                FALSE,
                                "jcormier@gmail.com"
                            );
INSERT INTO tbl_user VALUES (
                                4,
                                "Gabriel",
                                "Ralph Christian",
                                2,
                                "Qwerty123$",
                                TRUE,
                                "rgabriel@gmail.com"
                            );
INSERT INTO tbl_user VALUES (
                                5,
                                "Dini",
                                "Daddy",
                                3,
                                "Qwerty123$",
                                FALSE,
                                "ddini@gmail.com"
                            );

INSERT INTO tbl_projet VALUES (
                                  1,
                                  "test",
                                  "Lalalalalalalalalalalala description",
                                  25,
                                  1,
                                  3,
                                  FALSE,
                                  "projet3",
                                  "https://git.dti.crosemont.quebec/jcormier1/omgthisissocool"
                              );
INSERT INTO tbl_projet VALUES (
                                  2,
                                  "testdutest",
                                  "Lalalalalalalalalalalala description",
                                  18,
                                  2,
                                  4,
                                  FALSE,
                                  "projet4",
                                  "https://git.dti.crosemont.quebec/jcormier1/testtesttesttest"
                              );

INSERT INTO tbl_fichier VALUES(
                                  1,
                                  "chat.png",
                                  "TestTestTestTest",
                                  3
                              );
INSERT INTO tbl_fichier VALUES(
                                  2,
                                  "rigolo.docx",
                                  "hahahahahah",
                                  5
                              );
INSERT INTO tbl_fichier VALUES(
                                  3,
                                  "betaDasa.sql",
                                  "Jesaispasquoimettre",
                                  5
                              );


