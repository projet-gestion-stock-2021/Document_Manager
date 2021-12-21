
-- select document scanned by a user 
select document.Nom_Document , 
-- creationdoc.DateCreation ,
utilisateur.Nom , 
scan.Nom_Scan 
from scan
natural join niv_scan
natural join niveau
natural join utilisateur
natural join creationdoc
natural join document
where utilisateur.Nom = 'Didi';

-- select document with a tag
select document.Nom_Document , reference.Nom_Reference 
from reference
natural join typer
natural join document
where reference.Nom_Reference = 'dessin';

-- select document with 2 tags
select document.Nom_Document , reference.Nom_Reference 
from reference
natural join typer
natural join document
where reference.Nom_Reference = 'Eli' and reference.Nom_Reference = 'Neil';
-- marche pas à revoir
-- peut-être une histoire de jointure externe?

-- show all tags of a document
select document.Nom_Document , reference.Nom_Reference 
from reference
natural join typer
natural join document
where document.Id_Document = 50;

call delete_document("Nom_Document","1300_math_formulas.pdf");
call delete_document("Id_Document","3");
call delete_from_table ("document", "Nom_Document", "11406-programmez-avec-le-langage-c.pdf");
call delete_from_table ("utilisateur", "Nom", "Didi");
call delete_from_table ("utilisateur", "Id_Utilisateur", "4");

call delete_from_table ("document", "Nom_Document", "Active Directory Cookbook, 4th Edition.pdf");
call delete_from_table ("utilisateur", "Nom", "Cauwenbergh");

call insert_niveau('TETETETE'); 

select PASSWORD ('oaiai'), MD5 ('oaiai');

call insert_utilisateur ('Delforge', 'Laquement', 'b1@gmail.com', 'Secret1234', 1);

call update_dossiers("type_dossier",true, "Exchange", "Nom_type_dossier", "Projet"); -- probleme

call user_identification ("neil","test1");
call user_identification ('b1@gmail.com','Secret1234'); -- OK
call user_identification ('b1@gmail.com','Secret14');