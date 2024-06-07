package org.example.model.conjonction;

import org.example.model.affirmation.Affirmation;

public final class Ou extends ConjonctionDeCoordination {
    public Ou(Affirmation premièreAffirmation, Affirmation deuxièmeAffirmation) {
        super(premièreAffirmation, deuxièmeAffirmation);
    }

    @Override
    public String getStatut() {
        if(premièreAffirmation.getStatut().equals("vrai") || deuxièmeAffirmation.getStatut().equals("vrai")){
            return "vrai";
        }
        return "faux";
    }
}
