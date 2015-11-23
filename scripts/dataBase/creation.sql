CREATE TABLE `Preference` (
	`idPreference`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`aimeMusique`	INTEGER,
	`aimeAnimaux`	INTEGER,
	`fumeur`	INTEGER,
	`aimeDiscution`	INTEGER
);ntdape

CREATE TABLE `Ville` (
	`idVille`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`nom`	INTEGER,
	`codePostal`	INTEGER
);

CREATE TABLE `Profil` (
	`idProfil`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`pseudo`	TEXT NOT NULL,
	`pass`	TEXT NOT NULL,
	`email`	TEXT NOT NULL,
	`dateInscription`	TEXT NOT NULL,
	`dateNaissance`	TEXT NOT NULL,
	`nom`	TEXT NOT NULL,
	`prenom`	TEXT NOT NULL,
	`ville`	INTEGER NOT NULL,
	`preference`	INTEGER,
	FOREIGN KEY(`ville`) REFERENCES Ville(idVille),
	FOREIGN KEY(`preference`) REFERENCES Preference(idPreference)
);

CREATE TABLE `Trajet` (
	`idTrajet`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`villeDepart`	INTEGER NOT NULL,
	`villeArrivee`	INTEGER NOT NULL,
	`date`	TEXT NOT NULL,
	`heure`	TEXT NOT NULL,
	`places`	INTEGER NOT NULL,
	`prix`	REAL NOT NULL,
	`idConducteur`	INTEGER NOT NULL,
	FOREIGN KEY(`villeDepart`) REFERENCES Ville ( idVille ),
	FOREIGN KEY(`villeArrivee`) REFERENCES Ville ( idVille ),
	FOREIGN KEY(`idConducteur`) REFERENCES Profil(idProfil)
);

CREATE TABLE `Message` (
	`idMessage`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`objet`	TEXT,
	`contenu`	TEXT,
	`idDestinataire`	INTEGER,
	`idExpediteur`	INTEGER,
	`idTrajet`	INTEGER,
	FOREIGN KEY(`idDestinataire`) REFERENCES Profil ( idProfil ),
	FOREIGN KEY(`idExpediteur`) REFERENCES Profil ( idProfil ),
	FOREIGN KEY(`idTrajet`) REFERENCES Trajet ( idTrajet )
);

CREATE TABLE `Voyageurs` (
	`idPassager`	INTEGER,
	`idTrajet`	INTEGER,
	PRIMARY KEY(idPassager,idTrajet),
	FOREIGN KEY(`idPassager`) REFERENCES Profil ( idProfil ),
	FOREIGN KEY(`idTrajet`) REFERENCES Trajet ( idTrajet )
);

CREATE TABLE `Paiement` (
	`idProfil`	INTEGER,
	`idTrajet`	INTEGER,
	`paiementValide`	INTEGER,
	PRIMARY KEY(idProfil,idTrajet),
	FOREIGN KEY(`idProfil`) REFERENCES Profil ( idProfil ),
	FOREIGN KEY(`idTrajet`) REFERENCES Trajet ( idTrajet )
);