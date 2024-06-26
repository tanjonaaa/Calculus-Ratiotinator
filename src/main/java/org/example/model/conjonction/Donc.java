package org.example.model.conjonction;

import org.example.model.affirmation.Affirmation;

public final class Donc extends ConjonctionDeCoordination {
    public Donc(Affirmation premièreAffirmation, Affirmation deuxièmeAffirmation) {
        super(premièreAffirmation, deuxièmeAffirmation);
    }

    @Override
    public String getPhrase() {
        return premièreAffirmation.getPhrase() + ". Donc " + deuxièmeAffirmation.getPhrase();
    }

    @Override
    public String getStatut() {
        if(premièreAffirmation.getStatut().equals("vrai") && deuxièmeAffirmation.getStatut().equals("faux")){
            return "faux";
        } else if(premièreAffirmation.getStatut().equals("faux") || deuxièmeAffirmation.getStatut().equals("vrai")) {
            return "vrai";
        }
        return super.getStatut();
    }
}
