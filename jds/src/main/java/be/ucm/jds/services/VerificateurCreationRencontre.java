package be.ucm.jds.services;

import be.ucm.jds.BL.Entity.Rencontre;

public class VerificateurCreationRencontre {
    public boolean verificateurCreationRencontre(Rencontre rencontre) {
        return rencontre.getTitre() != null
                && rencontre.getAdresse() != null
                && rencontre.getDate() != null
                && rencontre.getTempDeJeu() > 0
                && rencontre.getNbrParticipantLimite() > 0
                && rencontre.getJeuList().size() > 0
                && rencontre.getUtilisateurCrea().getId() > 0;
    }
}
