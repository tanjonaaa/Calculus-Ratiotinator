package org.example.model.conjonction;

import org.example.model.affirmation.Affirmation;

public final class Donc extends ConjonctionDeCoordination {
    public Donc(Affirmation premièreAffirmation, Affirmation deuxièmeAffirmation) {
        super(premièreAffirmation, deuxièmeAffirmation);
    }

    @Override
    public String getStatut() {
        if(premièreAffirmation.getStatut().equals("vrai") && deuxièmeAffirmation.getStatut().equals("faux")){
            return "faux";
        }
        return "vrai";
    }
}
