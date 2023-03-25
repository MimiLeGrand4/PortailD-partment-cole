CREATE DATABASE projetSession;
USE projetSession;

CREATE TABLE tbl_accountType (
    accountType_id int,
    nom varchar(30),

    PRIMARY KEY (accountType_id)
);

CREATE TABLE tbl_user (
    user_id int,
    nom varchar(35),
    prenom varchar(35),
    accountType_id int,
    passwd varchar(99),
    tuteur Boolean,

    PRIMARY KEY (user_id),
    FOREIGN KEY (accountType_id) REFERENCES tbl_accountType(accountType_id)
);

CREATE TABLE tbl_projet (
    projet_id int,
    nom varchar(50),
    user_id int,
    statut Boolean,

    PRIMARY KEY (projet_id),
    FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
);

CREATE TABLE tbl_evaluation(
    user_id int,
    projet_id int,
    note int(3),
    commentaire text


    CONSTRAINT PK_tbl_evaluation PRIMARY KEY
    (
        user_id,
        projet_id 
    ),
    FOREIGN KEY (projet_id) REFERENCES tbl_projet(projet_id)
    FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
);

CREATE TABLE tbl_acces(
    acces_id int,
    nom varchar(30),

    PRIMARY KEY (acces_id)
);

CREATE TABLE tbl_invite(
    user_id int,
    projet_id int,
    acces_id int,

    CONSTRAINT PK_tbl_invite PRIMARY KEY
    (
        user_id,
        projet_id 
    ),
    FOREIGN KEY (projet_id) REFERENCES tbl_projet(projet_id)
    FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
    FOREIGN KEY (acces_id) REFERENCES tbl_acces(acces_id)
);

CREATE TABLE tbl_post (
    post_id int,
    projet_id int,
    caption varchar(50),
    user_id int,
    moment datetime,

    CONSTRAINT PK_tbl_post PRIMARY KEY
    (
        post_id,
        projet_id 
    ),
    FOREIGN KEY (projet_id) REFERENCES tbl_projet(projet_id)
    FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
);

CREATE TABLE tbl_fichier(
    fichier_id int,
    fichier_nom varchar(30),
    contenu varchar(100),

    PRIMARY KEY (fichier_id)
);

CREATE TABLE tbl_fichierPost(
    fichier_id int,
    post_id int,
    
    CONSTRAINT PK_tbl_fichierPost PRIMARY KEY
    (
        fichier_id,
        post_id 
    ),
    FOREIGN KEY (post_id) REFERENCES tbl_post(post_id)
    FOREIGN KEY (fichier_id) REFERENCES tbl_fichier(fichier_id)
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
    3,
    'ancienEtudiant'
);

INSERT INTO tbl_user VALUES (
    1,
    "Admin",
    "Admin",
    0,
    "root",
    FALSE
);
INSERT INTO tbl_user VALUES (
    2,
    "Invité",
    "Invité",
    1,
    "",
    FALSE
);
INSERT INTO tbl_user VALUES (
    3,
    "Cormier",
    "Jérémy",
    2,
    "RalphBisou",
    FALSE
);
INSERT INTO tbl_user VALUES (
    4,
    "Gabriel",
    "Ralph Christian",
    2,
    "Qwerty123$",
    TRUE
);
INSERT INTO tbl_user VALUES (
    5,
    "Dini",
    "Daddy",
    3,
    "Qwerty123$",
    FALSE
);

INSERT INTO tbl_projet VALUES (
    1,
    "test",
    3,
    FALSE
);

INSERT INTO tbl_acces VALUES (
    1,
    "Guest"
);
INSERT INTO tbl_acces VALUES (
    2,
    "Reporter"
);
INSERT INTO tbl_acces VALUES (
    3,
    "Developer"
);
INSERT INTO tbl_acces VALUES (
    4,
    "Maintainer"
);
INSERT INTO tbl_acces VALUES (
    5,
    "Owner"
);

INSERT INTO tbl_post VALUES (
    1,
    1,
    "Premier post du projet pour daddy dini",
    3,
    '20120618 10:34:09 AM'
);
INSERT INTO tbl_post VALUES (
    2,
    1,
    "Ajout dans le projet",
    4,
    '20120612 03:34:09 PM'
);

INSERT INTO tbl_fichier(
    1,
    "chat.png",
    "TestTestTestTest"
);
INSERT INTO tbl_fichier(
    2,
    "rigolo.docx",
    "hahahahahah"
);
INSERT INTO tbl_fichier(
    3,
    "betaDasa.sql",
    "Jesaispasquoimettre"
);

INSERT INTO tbl_fichierPost(
    1,
    1
);
INSERT INTO tbl_fichierPost(
    2,
    1
);
INSERT INTO tbl_fichierPost(
    3,
    2
);

