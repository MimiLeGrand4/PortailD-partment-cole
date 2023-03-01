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

    PRIMARY KEY (user_id),
    FOREIGN KEY (accountType_id) REFERENCES tbl_accountType(accountType_id)
);

CREATE TABLE tbl_projet (
    projet_id int,
    nom varchar(50),
    user_id int,
    postStatus_id int,

    PRIMARY KEY (projet_id),
    FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
);

CREATE TABLE tbl_post (
    post_id int,
    projet_id int,
    caption varchar(50),
    fichier varchar(100),
    user_id int,

    CONSTRAINT PK_tbl_post PRIMARY KEY
    (
        post_id,
        projet_id 
    ),
    FOREIGN KEY (projet_id) REFERENCES tbl_projet(projet_id)
    FOREIGN KEY (user_id) REFERENCES tbl_user(user_id)
);

INSERT INTO tbl_accountType VALUES (
    0,
    'Administrator'
);
INSERT INTO tbl_accountType VALUES (
    1,
    'invite'
);
INSERT INTO tbl_accountType VALUES (
    2,
    'compteNormal'
);
INSERT INTO tbl_accountType VALUES (
    3,
    'professeur'
);

INSERT INTO tbl_user VALUES (
    1,
    "Admin",
    "Admin",
    0,
    "root",
);
INSERT INTO tbl_user VALUES (
    2,
    "Invité",
    "Invité",
    1,
    "",
);
INSERT INTO tbl_user VALUES (
    3,
    "Cormier",
    "Jérémy",
    2,
    "RalphBisou",
);
INSERT INTO tbl_user VALUES (
    4,
    "Gabriel",
    "Ralph Christian",
    2,
    "Qwerty123$",
);
INSERT INTO tbl_user VALUES (
    5,
    "Dini",
    "Daddy",
    3,
    "Qwerty123$",
);

INSERT INTO tbl_projet VALUES (
    1,
    "test",
    3,
    1,
);

INSERT INTO tbl_post VALUES (
    1,
    1,
    "Premier post du projet pour daddy dini",
    "mettre le fichier ici",
    3,
);
INSERT INTO tbl_post VALUES (
    2,
    1,
    "Ajout dans le projet",
    "mettre le fichier ici",
    4,
);