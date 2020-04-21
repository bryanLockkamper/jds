Insert into Utilisateur (date_naissance, description, email, genre, nom, numero, password, prenom, pseudo) values ('1992-11-09', 'tototototo' , 'test@gmail.com', 'M', 'Test','0000001', '$2a$10$Hmsr.LL4EyEYQF/zjXubn.SLeRXKTjo9DtAi0PRyzhhtA5jmshnDS', 'Alex', 'Test') , ('1992-11-09', 'tototototo' , 'toto@gmail.com', 'M', 'Toto','0000002', '$2a$10$Hmsr.LL4EyEYQF/zjXubn.SLeRXKTjo9DtAi0PRyzhhtA5jmshnDS', 'Toto', 'Toto');

Insert into Genre (Description, Titre) Values ('Test1 Descrition', 'Test1') , ('Test2 Description', 'Test2');

Insert into Jeu (description, maison_edition, nbr_joueur_max, age_min, nbr_joueur_min, titre) values ('Jeu1 Description', 'Toto', 10, 1, 1, 'Titre Jeu1') , ('Jeu2 Description', 'Toto', 10, 11, 10, 'Titre Jeu2');

Insert into Jeu_Genres (jeu_list_id, genres_id) values (1, 1), ( 1, 2), (2, 1);

Insert into ADRESSE (CODE_POSTAL, NUMERO, RUE, VILLE) values (6666,'2a','Rue test de test', 'TestCitty');

Insert into Rencontre ( Date, Description, Nbr_Participant_Limite, Temps_De_Jeu, Titre, Adresse_id, Utilisateur_crea_id ) values ('2018-09-24', 'TestTestTestTestTest', 15, 160, 'Test', 1,1), ('2020-09-24', 'TestTestTestTestTest1', 15, 160, 'Test1', 1,1);

Insert into Role (Nom) values ('Admin'), ('UtilisateurLambda');

Insert into Role_UtilisateurDalList (Roles_Id, UtilisateurDalList_Id ) values (1,1) , (2,1) , (2,2);